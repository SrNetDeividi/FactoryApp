package factory;

import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import factory.AutomatedQualityControlServiceGrpc.AutomatedQualityControlServiceStub;
import factory.MachineServiceOuterClass.QualityFeedbackResponse;
import factory.MachineServiceOuterClass.QualityInspectionRequest;
import factory.MachineServiceOuterClass.QualityInspectionSummaryResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class AutomatedQualityControlClient {

    private final AutomatedQualityControlServiceStub asyncStub;

    public AutomatedQualityControlClient(ManagedChannel channel) {
        asyncStub = AutomatedQualityControlServiceGrpc.newStub(channel);
    }

    // Demonstrate sendQualityInspectionResults method
    public void sendQualityInspectionResults() {
        System.out.println("Starting sendQualityInspectionResults...");

        StreamObserver<QualityInspectionRequest> requestObserver =
            asyncStub.sendQualityInspectionResults(new StreamObserver<QualityInspectionSummaryResponse>() {
                @Override
                public void onNext(QualityInspectionSummaryResponse response) {
                    System.out.println("Summary: " +
                            "Total Inspected = " + response.getTotalInspected() +
                            ", Total Passed = " + response.getTotalPassed() +
                            ", Total Failed = " + response.getTotalFailed());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Completed sending quality inspection results.");
                }
            });

        try {
            // Send multiple inspection requests
            requestObserver.onNext(QualityInspectionRequest.newBuilder()
                .setProductId("123")
                .setInspectionResult("pass")
                .setInspectionTime("2024-08-08T12:00:00Z")
                .build());

            requestObserver.onNext(QualityInspectionRequest.newBuilder()
                .setProductId("124")
                .setInspectionResult("fail")
                .setInspectionTime("2024-08-08T12:05:00Z")
                .build());

            // Mark the end of requests
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            requestObserver.onError(e);
        }
    }

    // Demonstrate realTimeQualityFeedback method
    public void realTimeQualityFeedback() {
        System.out.println("Starting realTimeQualityFeedback...");

        StreamObserver<QualityInspectionRequest> requestObserver =
            asyncStub.realTimeQualityFeedback(new StreamObserver<QualityFeedbackResponse>() {
                @Override
                public void onNext(QualityFeedbackResponse response) {
                    System.out.println("Feedback: " +
                            "Product ID = " + response.getProductId() +
                            ", Feedback = " + response.getFeedback());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Completed real-time quality feedback.");
                }
            });

        try {
            // Send inspection requests and receive feedback
            requestObserver.onNext(QualityInspectionRequest.newBuilder()
                .setProductId("125")
                .setInspectionResult("pass")
                .setInspectionTime("2024-08-08T12:10:00Z")
                .build());

            requestObserver.onNext(QualityInspectionRequest.newBuilder()
                .setProductId("126")
                .setInspectionResult("fail")
                .setInspectionTime("2024-08-08T12:15:00Z")
                .build());

            // Mark the end of requests
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            requestObserver.onError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // Set logging level to WARNING to suppress DEBUG messages
        java.util.logging.Logger.getLogger("javax.jmdns").setLevel(java.util.logging.Level.WARNING);

        // JmDNS service discovery details
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "AutomatedQualityControlService";

        // Default values
        String host = "localhost";
        int port = 50051;

        // Create the channel and client
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();

        AutomatedQualityControlClient client = new AutomatedQualityControlClient(channel);

        // Run the methods to demonstrate their functionality
        System.out.println("Running methods:");
        client.sendQualityInspectionResults(); // Test client streaming
        Thread.sleep(3000); // Wait for the sendQualityInspectionResults to complete

        client.realTimeQualityFeedback(); // Test bidirectional streaming

        // Allow time for the client methods to complete
        Thread.sleep(5000);

        // Now perform JmDNS service discovery
        System.out.println("Discovering service with JmDNS...");

        try {
            try (JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost())) {
                ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
                if (serviceInfo != null) {
                    System.out.println("Service discovered: " + serviceInfo.getName() + " at " +
                            serviceInfo.getHostAddresses()[0] + ":" + serviceInfo.getPort());
                } else {
                    System.err.println("Service not found.");
                }
            }
        } catch (Exception e) {
            System.err.println("JmDNS error: " + e.getMessage());
        }

        // Shutdown the channel
        channel.shutdownNow().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
