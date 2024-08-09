package factory;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import factory.AssemblyLineDataServiceGrpc.AssemblyLineDataServiceStub;
import factory.MachineServiceOuterClass.AssemblyLineDataRequest;
import factory.MachineServiceOuterClass.AssemblyLineDataResponse;
import factory.MachineServiceOuterClass.StartAssemblyLineRequest;
import factory.MachineServiceOuterClass.StartAssemblyLineResponse;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class AssemblyLineDataClient {

    public static void main(String[] args) {
        ManagedChannel channel = null; // Declare channel here for later shutdown

        try {
            // Discover the service with JmDNS
            System.out.println("Discovering service with JmDNS...");
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = jmdns.getServiceInfo("_grpc._tcp.local.", "AssemblyLineDataService");

            // Check if service was discovered
            if (serviceInfo == null) {
                System.err.println("Service not found.");
                return;
            }

            // Extract host and port from discovered service
            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            System.out.println("Discovered service at " + host + ":" + port);

            // Create a channel to the server using the discovered port
            channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();
            
            // Create a stub for the service
            AssemblyLineDataServiceStub stub = AssemblyLineDataServiceGrpc.newStub(channel);

            // Stream Assembly Line Data
            StreamObserver<AssemblyLineDataResponse> responseObserver = new StreamObserver<AssemblyLineDataResponse>() {
                @Override
                public void onNext(AssemblyLineDataResponse response) {
                    // Handle each response received from the server
                    System.out.println("Method: streamAssemblyLineData");
                    System.out.println("Received data: " +
                            "Assembly Line ID = " + response.getAssemblyLineId() +
                            ", Timestamp = " + response.getTimestamp() +
                            ", Units Produced = " + response.getUnitsProduced() +
                            ", Defect Rate = " + response.getDefectRate());
                }

                @Override
                public void onError(Throwable t) {
                    // Handle errors during streaming
                    System.err.println("StreamAssemblyLineData failed: " + t.getMessage());
                    t.printStackTrace(); // Print stack trace for more details
                }

                @Override
                public void onCompleted() {
                    // Called when the server has completed sending responses
                    System.out.println("StreamAssemblyLineData completed.");
                }
            };

            // Create the request message for streaming
            AssemblyLineDataRequest request = AssemblyLineDataRequest.newBuilder()
                    .setAssemblyLineId("assembly_line_1")
                    .build();

            // Call the RPC method to start streaming
            stub.streamAssemblyLineData(request, responseObserver);

            // Start Assembly Line
            StreamObserver<StartAssemblyLineResponse> startResponseObserver = new StreamObserver<StartAssemblyLineResponse>() {
                @Override
                public void onNext(StartAssemblyLineResponse response) {
                    // Handle each response received from the server
                    System.out.println("Method: startAssemblyLine");
                    System.out.println("Received start response: " +
                            "Assembly Line ID = " + response.getAssemblyLineId() +
                            ", Status = " + response.getStatus());
                }

                @Override
                public void onError(Throwable t) {
                    // Handle errors during starting the assembly line
                    System.err.println("StartAssemblyLine failed: " + t.getMessage());
                    t.printStackTrace(); // Print stack trace for more details
                }

                @Override
                public void onCompleted() {
                    // Called when the server has completed sending responses
                    System.out.println("StartAssemblyLine completed.");
                }
            };

            // Create the start request message
            StartAssemblyLineRequest startRequest = StartAssemblyLineRequest.newBuilder()
                    .setAssemblyLineId("assembly_line_1")
                    .build();

            // Call the RPC method to start the assembly line
            stub.startAssemblyLine(startRequest, startResponseObserver);

            // Allow some time to receive responses
            Thread.sleep(15000);

        } catch (IOException e) {
            // Handle errors related to JmDNS service discovery
            System.err.println("Failed to create JmDNS instance or discover service: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Handle errors related to thread sleep or channel shutdown
            System.err.println("Thread was interrupted: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Shut down the channel to the server
            if (channel != null) {
                try {
                    channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    System.err.println("Channel shutdown was interrupted: " + e.getMessage());
                }
            }
        }
    }
}
