
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;

import factory.MachineServiceGrpc;
import factory.MachineServiceOuterClass.MachineStatusRequest;
import factory.MachineServiceOuterClass.MachineStatusResponse;
import factory.MachineServiceOuterClass.MaintenanceRequest;
import factory.MachineServiceOuterClass.MaintenanceResponse;

public class MachineServiceClient {

    private final ManagedChannel channel;
    private final MachineServiceGrpc.MachineServiceBlockingStub blockingStub;

    public MachineServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();
        this.blockingStub = MachineServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getMachineStatus(String machineId) {
        MachineStatusRequest request = MachineStatusRequest.newBuilder()
            .setMachineId(machineId)
            .build();
        MachineStatusResponse response = blockingStub.getMachineStatus(request);
        System.out.println("Machine Status: " + response);
    }

    public void initiateMaintenance(String machineId, String maintenanceType) {
        MaintenanceRequest request = MaintenanceRequest.newBuilder()
            .setMachineId(machineId)
            .setMaintenanceType(maintenanceType)
            .build();
        MaintenanceResponse response = blockingStub.initiateMaintenance(request);
        System.out.println("Maintenance Response: " + response);
    }

    public static void main(String[] args) throws InterruptedException {
        MachineServiceClient client = new MachineServiceClient("localhost", 8081);
        try {
            client.getMachineStatus("1234");
            client.initiateMaintenance("1234", "Full");
        } finally {
            client.shutdown();
        }
    }
}
