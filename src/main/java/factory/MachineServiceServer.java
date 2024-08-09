package factory;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

import factory.MachineServiceOuterClass.MachineStatusResponse;
import factory.MachineServiceOuterClass.MaintenanceRequest;
import factory.MachineServiceOuterClass.MaintenanceResponse;
import factory.MachineServiceGrpc;
import factory.MachineServiceOuterClass.MachineStatusRequest;
import factory.MachineServiceOuterClass.MachineStatusResponse;


public class MachineServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8081)
            .addService(new MachineServiceImpl())
            .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }

    static class MachineServiceImpl extends MachineServiceGrpc.MachineServiceImplBase {

        @Override
        public void getMachineStatus(MachineStatusRequest request, StreamObserver<MachineStatusResponse> responseObserver) {
            String machineId = request.getMachineId();
            // Simulate fetching machine status
            MachineStatusResponse response = MachineStatusResponse.newBuilder()
                .setMachineId(machineId)
                .setStatus("Operational")
                .setLastMaintenanceDate("2023-07-01")
                .setCurrentEfficiency(95.5f)
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        
        public void initiateMaintenance(MaintenanceRequest request, StreamObserver<MaintenanceResponse> responseObserver) {
            String machineId = request.getMachineId();
            String maintenanceType = request.getMaintenanceType();
            // Simulate initiating maintenance
            MaintenanceResponse response = MaintenanceResponse.newBuilder()
                .setMachineId(machineId)
                .setStatus("Maintenance Initiated: " + maintenanceType)
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
