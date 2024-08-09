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

    // Asynchronous stub for making non-blocking gRPC calls
    private final AutomatedQualityControlServiceStub asyncStub;

    // Constructor initializes the asyncStub with the given gRPC channel
    public AutomatedQualityControlClient(ManagedChannel channel) {
        asyncStub = AutomatedQualityControlServiceGrpc.newStub(channel);
    }

    // Method to demonstrate sending quality inspection results to the server
    public void sendQualityInspectionResults() {
        System.out.println("Method: sendQualityInspectionResults");
        System.out.println("Starting sendQualityInspectionResults...");

        // StreamObserver for handling server responses asynchronously
        StreamObserver<QualityInspectionRequest> requestObserver =
            asyncStub.sendQualityInspectionResults(new StreamObserver<QualityInspectionSummaryResponse>() {
                @Override
                public void onNext(QualityInspectionSummaryResponse response) {
                    // Called when the server sends a response
                    String formattedResponse = String.format(
                        "Quality Inspection Summary:\n" +
                        "  Total Inspected : %d\n" +
                        "  Total Passed    : %d\n" +
                        "  Total Failed    : %d",
                        response.getTotalInspected(),
                        response.getTotalPassed(),
                        response.getTotalFailed()
                    );
                    System.out.println(formattedResponse);
                }

                @Override
                public void onError(Throwable t) {
                    // Called if an error occurs during the RPC
                    System.err.println("Error during sendQualityInspectionResults: " + t.getMessage());
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    // Called when the server has completed sending responses
                    System.out.println("Completed sending quality inspection results.");
                }
            });

        try {
            // Send multiple inspection requests to the server
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
            // Handle any runtime exceptions and notify the server of the error
            System.err.println("RuntimeException during sendQualityInspectionResults: " + e.getMessage());
            e.printStackTrace();
            requestObserver.onError(e);
        }
    }

    // Method to demonstrate real-time quality feedback interaction with the server
    public void realTimeQualityFeedback() {
        System.out.println("Method: realTimeQualityFeedback");
        System.out.println("Starting realTimeQualityFeedback...");

        // StreamObserver for handling server responses asynchronously
        StreamObserver<QualityInspectionRequest> requestObserver =
            asyncStub.realTimeQualityFeedback(new StreamObserver<QualityFeedbackResponse>() {
                @Override
                public void onNext(QualityFeedbackResponse response) {
                    // Called when the server sends a response
                    String formattedResponse = String.format(
                        "Real-Time Quality Feedback:\n" +
                        "  Product ID : %s\n" +
                        "  Feedback   : %s",
                        response.getProductId(),
                        response.getFeedback()
                    );
                    System.out.println(formattedResponse);
                }

                @Override
                public void onError(Throwable t) {
                    // Called if an error occurs during the RPC
                    System.err.println("Error during realTimeQualityFeedback: " + t.getMessage());
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    // Called when the server has completed sending responses
                    System.out.println("Completed real-time quality feedback.");
                }
            });

        try {
            // Send inspection requests to the server and receive feedback
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
            // Handle any runtime exceptions and notify the server of the error
            System.err.println("RuntimeException during realTimeQualityFeedback: " + e.getMessage());
            e.printStackTrace();
            requestObserver.onError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // Set logging level to WARNING to suppress DEBUG messages from JmDNS
        java.util.logging.Logger.getLogger("javax.jmdns").setLevel(java.util.logging.Level.WARNING);

        // JmDNS service discovery details
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "AutomatedQualityControlService";

        // Default values for gRPC connection
        String host = "localhost";
        int port = 50051;

        // Create the channel for communication with the gRPC server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();

        // Initialize the client with the created channel
        AutomatedQualityControlClient client = new AutomatedQualityControlClient(channel);

        try {
            // Run the methods to demonstrate their functionality
            System.out.println("Running methods:");
            client.sendQualityInspectionResults(); // Test client streaming
            Thread.sleep(3000); // Wait for the sendQualityInspectionResults to complete

            client.realTimeQualityFeedback(); // Test bidirectional streaming

            // Allow time for the client methods to complete
            Thread.sleep(5000);

            // Perform JmDNS service discovery
            System.out.println("Discovering service with JmDNS...");

            try (JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost())) {
                ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
                if (serviceInfo != null) {
                    System.out.println("Service discovered: " + serviceInfo.getName() + " at " +
                            serviceInfo.getHostAddresses()[0] + ":" + serviceInfo.getPort());
                } else {
                    System.err.println("Service not found.");
                }
            } catch (Exception e) {
                // Handle errors during JmDNS service discovery
                System.err.println("JmDNS error: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            // Handle unexpected errors during the main execution
            System.err.println("Unexpected error in main: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure the gRPC channel is properly shut down
            if (channel != null && !channel.isShutdown()) {
                channel.shutdownNow().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
            }
        }
    }
}
