package factory;

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

    // Update the client to connect to port 5053
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

        // Improved formatting for machine status output with method name
        String formattedResponse = String.format(
            "Method: getMachineStatus\n" +
            "Machine Status:\n" +
            "  Machine ID          : %s\n" +
            "  Status              : %s\n" +
            "  Last Maintenance    : %s\n" +
            "  Current Efficiency  : %.2f%%",
            response.getMachineId(),
            response.getStatus(),
            response.getLastMaintenanceDate(),
            response.getCurrentEfficiency()
        );

        System.out.println(formattedResponse);
    }

    public void initiateMaintenance(String machineId, String maintenanceType) {
        MaintenanceRequest request = MaintenanceRequest.newBuilder()
            .setMachineId(machineId)
            .setMaintenanceType(maintenanceType)
            .build();
        MaintenanceResponse response = blockingStub.initiateMaintenance(request);

        // Improved formatting for maintenance response output with method name
        String formattedResponse = String.format(
            "Method: initiateMaintenance\n" +
            "Maintenance Response:\n" +
            "  Machine ID    : %s\n" +
            "  Status        : %s",
            response.getMachineId(),
            response.getStatus()
        );

        System.out.println(formattedResponse);
    }

    public static void main(String[] args) throws InterruptedException {
        // Connect to the server on port 5053
        MachineServiceClient client = new MachineServiceClient("localhost", 5053);
        try {
            client.getMachineStatus("1234");

            // Introduce a delay of 2 seconds between the method calls
            Thread.sleep(2000);

            client.initiateMaintenance("1234", "Full");
        } finally {
            client.shutdown();
        }
    }
}
