package factory;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import factory.AssemblyLineDataServiceGrpc.AssemblyLineDataServiceImplBase;
import factory.MachineServiceOuterClass.AssemblyLineDataRequest;
import factory.MachineServiceOuterClass.AssemblyLineDataResponse;
import factory.MachineServiceOuterClass.StartAssemblyLineRequest;
import factory.MachineServiceOuterClass.StartAssemblyLineResponse;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AssemblyLineDataServer extends AssemblyLineDataServiceImplBase {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void streamAssemblyLineData(AssemblyLineDataRequest request, StreamObserver<AssemblyLineDataResponse> responseObserver) {
        // Simulate streaming data
        scheduler.scheduleAtFixedRate(() -> {
            AssemblyLineDataResponse response = AssemblyLineDataResponse.newBuilder()
                    .setAssemblyLineId(request.getAssemblyLineId())
                    .setTimestamp(System.currentTimeMillis() + "")
                    .setUnitsProduced((int) (Math.random() * 100))
                    .setDefectRate(Math.random() * 0.1)
                    .build();
            responseObserver.onNext(response);
        }, 0, 2, TimeUnit.SECONDS); // Send data every 2 seconds

        // Stop sending data after 10 seconds
        scheduler.schedule(() -> {
            responseObserver.onCompleted();
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }

    @Override
    public void startAssemblyLine(StartAssemblyLineRequest request, StreamObserver<StartAssemblyLineResponse> responseObserver) {
        // Implement your logic here, this is just a placeholder
        StartAssemblyLineResponse response = StartAssemblyLineResponse.newBuilder()
                .setAssemblyLineId(request.getAssemblyLineId())
                .setStatus("Started")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // Create and start the gRPC server
        Server server = ServerBuilder.forPort(50051)
                .addService(new AssemblyLineDataServer())
                .build()
                .start();

        System.out.println("Server started on port 50051");

        // Register the service with JmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "AssemblyLineDataService", 50051, "gRPC Assembly Line Data Service");
        jmdns.registerService(serviceInfo);
        System.out.println("AssemblyLineDataService has been registered with JmDNS.");

        // Allow some time to receive responses
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server since JVM is shutting down.");
            server.shutdown();
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        server.awaitTermination();
    }
}
