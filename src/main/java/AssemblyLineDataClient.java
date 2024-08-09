import factory.AssemblyLineDataServiceGrpc;
import factory.MachineServiceOuterClass.AssemblyLineDataRequest;
import factory.MachineServiceOuterClass.AssemblyLineDataResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class AssemblyLineDataClient {

    public static void main(String[] args) throws InterruptedException {
        // Create a channel to the server
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        
        // Create a stub for the service
        AssemblyLineDataServiceGrpc.AssemblyLineDataServiceStub stub = AssemblyLineDataServiceGrpc.newStub(channel);

        // Create a response observer
        StreamObserver<AssemblyLineDataResponse> responseObserver = new StreamObserver<AssemblyLineDataResponse>() {
            @Override
            public void onNext(AssemblyLineDataResponse response) {
                System.out.println("Received data: " +
                        "Assembly Line ID = " + response.getAssemblyLineId() +
                        ", Timestamp = " + response.getTimestamp() +
                        ", Units Produced = " + response.getUnitsProduced() +
                        ", Defect Rate = " + response.getDefectRate());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("StreamAssemblyLineData failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("StreamAssemblyLineData completed.");
            }
        };

        // Create the request message
        AssemblyLineDataRequest request = AssemblyLineDataRequest.newBuilder()
                .setAssemblyLineId("assembly_line_1")
                .build();

        // Call the RPC method
        stub.streamAssemblyLineData(request, responseObserver);

        // Allow some time to receive responses
        Thread.sleep(15000);

        // Shut down channel
        channel.shutdownNow().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
