package factory;

import io.grpc.BindableService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import factory.AssemblyLineDataServiceGrpc.AssemblyLineDataServiceStub;
import factory.MachineServiceOuterClass.AssemblyLineDataRequest;
import factory.MachineServiceOuterClass.AssemblyLineDataResponse;
import factory.MachineServiceOuterClass.StartAssemblyLineRequest;
import factory.MachineServiceOuterClass.StartAssemblyLineResponse;
import factory.MachineServiceGrpc;
import factory.MachineServiceOuterClass.MachineStatusRequest;
import factory.MachineServiceOuterClass.MachineStatusResponse;
import factory.MachineServiceOuterClass.MaintenanceRequest;
import factory.MachineServiceOuterClass.MaintenanceResponse;

public class GeneralGUI {

    // Client objects for different services
    private AutomatedQualityControlClient qualityControlClient;
    private AssemblyLineDataServiceStub assemblyLineDataClient;
    private ManagedChannel qualityControlChannel;
    private ManagedChannel assemblyLineDataChannel;
    private MachineServiceClient machineServiceClient;

    // Server references
    private Server qualityControlServer;
    private Server assemblyLineServer;
    private Server machineServiceServer;

    // UI components for displaying status and responses
    private JTextArea responseArea;
    private JTextArea qualityControlServerStatus;
    private JTextArea assemblyLineServerStatus;
    private JTextArea machineServiceServerStatus;

    public static void main(String[] args) {
        // Run the GUI creation code on the Swing event dispatch thread
        SwingUtilities.invokeLater(GeneralGUI::new);
    }

    public GeneralGUI() {
        // Create the main window for the application
        JFrame frame = new JFrame("General GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(new BorderLayout());

        // Create a JTextArea for displaying responses and add it to a scroll pane
        responseArea = new JTextArea();
        responseArea.setEditable(false);
        JScrollPane responseScrollPane = new JScrollPane(responseArea);
        frame.add(responseScrollPane, BorderLayout.CENTER);

        // Create a panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));

        // Create buttons for starting servers and other actions
        JButton startQualityControlServerButton = new JButton("Start Quality Control Server");
        JButton sendQualityInspectionButton = new JButton("Send Quality Inspection Results");
        JButton realTimeFeedbackButton = new JButton("Real-Time Quality Feedback");

        JButton startAssemblyLineServerButton = new JButton("Start Assembly Line Server");
        JButton startAssemblyLineButton = new JButton("Start Assembly Line");
        JButton streamAssemblyLineDataButton = new JButton("Stream Assembly Line Data");

        JButton startMachineServiceServerButton = new JButton("Start Machine Service Server");
        JButton getMachineStatusButton = new JButton("Get Machine Status");
        JButton initiateMaintenanceButton = new JButton("Initiate Maintenance");

        // Add action listeners to buttons to define their behavior
        startQualityControlServerButton.addActionListener(new StartServerAction("Quality Control Server", 50051));
        sendQualityInspectionButton.addActionListener(new SendQualityInspectionAction());
        realTimeFeedbackButton.addActionListener(new RealTimeFeedbackAction());

        startAssemblyLineServerButton.addActionListener(new StartServerAction("Assembly Line Server", 50052));
        startAssemblyLineButton.addActionListener(new StartAssemblyLineAction());
        streamAssemblyLineDataButton.addActionListener(new StreamAssemblyLineDataAction());

        startMachineServiceServerButton.addActionListener(new StartMachineServiceServerAction());
        getMachineStatusButton.addActionListener(new GetMachineStatusAction());
        initiateMaintenanceButton.addActionListener(new InitiateMaintenanceAction());

        // Add buttons to the button panel
        buttonPanel.add(startQualityControlServerButton);
        buttonPanel.add(sendQualityInspectionButton);
        buttonPanel.add(realTimeFeedbackButton);

        buttonPanel.add(startAssemblyLineServerButton);
        buttonPanel.add(startAssemblyLineButton);
        buttonPanel.add(streamAssemblyLineDataButton);

        buttonPanel.add(startMachineServiceServerButton);
        buttonPanel.add(getMachineStatusButton);
        buttonPanel.add(initiateMaintenanceButton);

        // Add the button panel to the frame
        frame.add(buttonPanel, BorderLayout.WEST);

        // Create a panel to display server statuses
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(3, 1));

        // Create text areas for server status
        qualityControlServerStatus = new JTextArea("Quality Control Server: Not Running");
        qualityControlServerStatus.setEditable(false);
        statusPanel.add(new JScrollPane(qualityControlServerStatus));

        assemblyLineServerStatus = new JTextArea("Assembly Line Server: Not Running");
        assemblyLineServerStatus.setEditable(false);
        statusPanel.add(new JScrollPane(assemblyLineServerStatus));

        machineServiceServerStatus = new JTextArea("Machine Service Server: Not Running");
        machineServiceServerStatus.setEditable(false);
        statusPanel.add(new JScrollPane(machineServiceServerStatus));

        // Add the status panel to the frame
        frame.add(statusPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);

        // Redirect console output to the JTextArea
        redirectConsoleOutput();
    }

    // ActionListener for starting different servers
    private class StartServerAction implements ActionListener {
        private final String serverName;
        private final int port;

        public StartServerAction(String serverName, int port) {
            this.serverName = serverName;
            this.port = port;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Update server status in the UI
            if (serverName.equals("Quality Control Server")) {
                qualityControlServerStatus.setText("Quality Control Server: Starting...");
            } else if (serverName.equals("Assembly Line Server")) {
                assemblyLineServerStatus.setText("Assembly Line Server: Starting...");
            } else if (serverName.equals("Machine Service Server")) {
                machineServiceServerStatus.setText("Machine Service Server: Starting...");
            }

            // Start the server in a new thread to avoid blocking the UI
            new Thread(() -> {
                try {
                    if (serverName.equals("Quality Control Server")) {
                        qualityControlServer = ServerBuilder.forPort(port)
                                .addService(new AutomatedQualityControlServer())
                                .build()
                                .start();
                        SwingUtilities.invokeLater(() -> qualityControlServerStatus.setText("Quality Control Server: Running on port " + port));
                    } else if (serverName.equals("Assembly Line Server")) {
                        assemblyLineServer = ServerBuilder.forPort(port)
                                .addService(new AssemblyLineDataServer())
                                .build()
                                .start();
                        SwingUtilities.invokeLater(() -> assemblyLineServerStatus.setText("Assembly Line Server: Running on port " + port));
                    } else if (serverName.equals("Machine Service Server")) {
                        machineServiceServer = ServerBuilder.forPort(port)
                                .addService((BindableService) new MachineServiceServer())
                                .build()
                                .start();
                        SwingUtilities.invokeLater(() -> machineServiceServerStatus.setText("Machine Service Server: Running on port " + port));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
    }

    // ActionListener for sending quality inspection results
    private class SendQualityInspectionAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setupQualityControlClient();
                qualityControlClient.sendQualityInspectionResults();
                JOptionPane.showMessageDialog(null, "Quality Inspection Results Sent");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to send quality inspection results");
            }
        }
    }

    // ActionListener for starting real-time quality feedback
    private class RealTimeFeedbackAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setupQualityControlClient();
                qualityControlClient.realTimeQualityFeedback();
                JOptionPane.showMessageDialog(null, "Real-Time Quality Feedback Started");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to start real-time quality feedback");
            }
        }
    }

    // ActionListener for starting the assembly line
    private class StartAssemblyLineAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setupAssemblyLineDataClient();
                StartAssemblyLineRequest request = StartAssemblyLineRequest.newBuilder()
                        .setAssemblyLineId("assembly_line_1")
                        .build();

                // Send the start request and handle the response
                assemblyLineDataClient.startAssemblyLine(request, new StreamObserver<StartAssemblyLineResponse>() {
                    @Override
                    public void onNext(StartAssemblyLineResponse response) {
                        appendToResponseArea("Received start response: " +
                                "Assembly Line ID = " + response.getAssemblyLineId() +
                                ", Status = " + response.getStatus());
                    }

                    @Override
                    public void onError(Throwable t) {
                        appendToResponseArea("StartAssemblyLine failed: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        appendToResponseArea("StartAssemblyLine completed.");
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to start assembly line");
            }
        }
    }

    // ActionListener for streaming assembly line data
    private class StreamAssemblyLineDataAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setupAssemblyLineDataClient();
                AssemblyLineDataRequest request = AssemblyLineDataRequest.newBuilder()
                        .setAssemblyLineId("assembly_line_1")
                        .build();

                // Stream data from the assembly line
                assemblyLineDataClient.streamAssemblyLineData(request, new StreamObserver<AssemblyLineDataResponse>() {
                    @Override
                    public void onNext(AssemblyLineDataResponse response) {
                        // Display the response in the UI
                        appendToResponseArea("Method: streamAssemblyLineData\nReceived data: " +
                                "Assembly Line ID = " + response.getAssemblyLineId() +
                                ", Timestamp = " + response.getTimestamp() +
                                ", Units Produced = " + response.getUnitsProduced() +
                                ", Defect Rate = " + response.getDefectRate() + "\n");
                    }

                    @Override
                    public void onError(Throwable t) {
                        appendToResponseArea("StreamAssemblyLineData failed: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        appendToResponseArea("StreamAssemblyLineData completed.\n");
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                appendToResponseArea("Failed to start streaming assembly line data.\n");
            }
        }
    }

    // ActionListener for starting the Machine Service server
    private class StartMachineServiceServerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(() -> {
                try {
                    MachineServiceServer.main(new String[]{});
                    SwingUtilities.invokeLater(() -> machineServiceServerStatus.setText("Machine Service Server: Running on port 8081"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
    }

    // ActionListener for getting the machine status
    private class GetMachineStatusAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setupMachineServiceClient();
                machineServiceClient.getMachineStatus("1234");
                JOptionPane.showMessageDialog(null, "Machine Status Fetched");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to fetch machine status");
            }
        }
    }

    // ActionListener for initiating maintenance
    private class InitiateMaintenanceAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setupMachineServiceClient();
                machineServiceClient.initiateMaintenance("1234", "Full");
                JOptionPane.showMessageDialog(null, "Maintenance Initiated");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to initiate maintenance");
            }
        }
    }

    // Method to set up the Quality Control client
    private void setupQualityControlClient() {
        if (qualityControlChannel == null || qualityControlChannel.isShutdown()) {
            qualityControlChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();
            qualityControlClient = new AutomatedQualityControlClient(qualityControlChannel);
        }
    }

    // Method to set up the Assembly Line Data client
    private void setupAssemblyLineDataClient() {
        if (assemblyLineDataChannel == null || assemblyLineDataChannel.isShutdown()) {
            assemblyLineDataChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();
            assemblyLineDataClient = AssemblyLineDataServiceGrpc.newStub(assemblyLineDataChannel);
        }
    }

    // Method to set up the Machine Service client
    private void setupMachineServiceClient() {
        if (machineServiceClient == null) {
            machineServiceClient = new MachineServiceClient("localhost", 8081);
        }
    }

    // Method to append messages to the response area
    private void appendToResponseArea(String message) {
        SwingUtilities.invokeLater(() -> {
            responseArea.append(message + "\n");
            responseArea.setCaretPosition(responseArea.getDocument().getLength());
        });
    }

    // Method to redirect console output to the JTextArea
    private void redirectConsoleOutput() {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        System.setOut(new PrintStream(System.out) {
            @Override
            public void println(String x) {
                appendToResponseArea(x);
                originalOut.println(x);
            }

            @Override
            public void println(Object x) {
                appendToResponseArea(String.valueOf(x));
                originalOut.println(x);
            }
        });

        System.setErr(new PrintStream(System.err) {
            @Override
            public void println(String x) {
                appendToResponseArea("ERROR: " + x);
                originalErr.println(x);
            }

            @Override
            public void println(Object x) {
                appendToResponseArea("ERROR: " + String.valueOf(x));
                originalErr.println(x);
            }
        });
    }
}
