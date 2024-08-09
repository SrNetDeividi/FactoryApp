package factory;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import factory.AutomatedQualityControlServiceGrpc.AutomatedQualityControlServiceImplBase;
import factory.MachineServiceOuterClass.QualityFeedbackResponse;
import factory.MachineServiceOuterClass.QualityInspectionRequest;
import factory.MachineServiceOuterClass.QualityInspectionSummaryResponse;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

public class AutomatedQualityControlServer extends AutomatedQualityControlServiceImplBase {

    private final AtomicInteger totalInspected = new AtomicInteger(0);
    private final AtomicInteger totalPassed = new AtomicInteger(0);
    private final AtomicInteger totalFailed = new AtomicInteger(0);

    @Override
    public StreamObserver<QualityInspectionRequest> sendQualityInspectionResults(
        StreamObserver<QualityInspectionSummaryResponse> responseObserver) {

        return new StreamObserver<QualityInspectionRequest>() {
            @Override
            public void onNext(QualityInspectionRequest request) {
                totalInspected.incrementAndGet();
                if ("pass".equalsIgnoreCase(request.getInspectionResult())) {
                    totalPassed.incrementAndGet();
                } else {
                    totalFailed.incrementAndGet();
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                QualityInspectionSummaryResponse response =
                    QualityInspectionSummaryResponse.newBuilder()
                        .setTotalInspected(totalInspected.get())
                        .setTotalPassed(totalPassed.get())
                        .setTotalFailed(totalFailed.get())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<QualityInspectionRequest> realTimeQualityFeedback(
        StreamObserver<QualityFeedbackResponse> responseObserver) {

        return new StreamObserver<QualityInspectionRequest>() {
            @Override
            public void onNext(QualityInspectionRequest request) {
                String feedback = "Feedback for " + request.getProductId() + ": ";
                if ("pass".equalsIgnoreCase(request.getInspectionResult())) {
                    feedback += "Good job!";
                } else {
                    feedback += "Please check the product.";
                }

                QualityFeedbackResponse response =
                    QualityFeedbackResponse.newBuilder()
                        .setProductId(request.getProductId())
                        .setFeedback(feedback)
                        .build();

                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        AutomatedQualityControlServer service = new AutomatedQualityControlServer();
        int port = 50051; // Port on which the server will listen

        Server grpcServer = ServerBuilder.forPort(port)
                .addService(service)
                .build()
                .start();

        System.out.println("AutomatedQualityControlServer started, listening on " + port);

        // Register the service with JmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "AutomatedQualityControlService", port, "gRPC AutomatedQualityControlService");
        jmdns.registerService(serviceInfo);

        // Print confirmation that the service has been registered
        System.out.println("AutomatedQualityControlService has been registered with JmDNS:");
        System.out.println("Service Name: " + serviceInfo.getName());
        System.out.println("Service Type: " + serviceInfo.getType());
        System.out.println("Service Port: " + serviceInfo.getPort());
        System.out.println("Service Description: " + serviceInfo.getDomain());

        // Keep the server running
        grpcServer.awaitTermination();
    }
}
