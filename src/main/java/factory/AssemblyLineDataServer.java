package factory;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import factory.AssemblyLineDataServiceGrpc.AssemblyLineDataServiceImplBase;
import factory.MachineServiceOuterClass.AssemblyLineDataRequest;
import factory.MachineServiceOuterClass.AssemblyLineDataResponse;
import factory.MachineServiceOuterClass.StartAssemblyLineRequest;
import factory.MachineServiceOuterClass.StartAssemblyLineResponse;

import java.io.IOException;

public class AssemblyLineDataServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        final int port = 50051;
        final Server server = ServerBuilder.forPort(port)
                .addService(new AssemblyLineDataServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }

    static class AssemblyLineDataServiceImpl extends AssemblyLineDataServiceImplBase {
        @Override
        public void streamAssemblyLineData(AssemblyLineDataRequest request,
                                            StreamObserver<AssemblyLineDataResponse> responseObserver) {
            // Simulate streaming data
            for (int i = 0; i < 10; i++) {
                AssemblyLineDataResponse response = AssemblyLineDataResponse.newBuilder()
                        .setAssemblyLineId(request.getAssemblyLineId())
                        .setTimestamp(String.valueOf(System.currentTimeMillis()))
                        .setUnitsProduced(i * 10)
                        .setDefectRate(i % 5)
                        .build();
                responseObserver.onNext(response);

                try {
                    Thread.sleep(1000); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            responseObserver.onCompleted();
        }

        @Override
        public void startAssemblyLine(StartAssemblyLineRequest request,
                                      StreamObserver<StartAssemblyLineResponse> responseObserver) {
            // Simulate starting an assembly line
            StartAssemblyLineResponse response = StartAssemblyLineResponse.newBuilder()
                    .setAssemblyLineId(request.getAssemblyLineId())
                    .setStatus("Started")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
