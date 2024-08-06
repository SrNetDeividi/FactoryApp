import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * MachineMonitoringService definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: smartfactosca.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MachineMonitoringServiceGrpc {

  private MachineMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "MachineMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Smartfactosca.MachineStatusRequest,
      Smartfactosca.MachineStatusResponse> getGetMachineStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMachineStatus",
      requestType = Smartfactosca.MachineStatusRequest.class,
      responseType = Smartfactosca.MachineStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Smartfactosca.MachineStatusRequest,
      Smartfactosca.MachineStatusResponse> getGetMachineStatusMethod() {
    io.grpc.MethodDescriptor<Smartfactosca.MachineStatusRequest, Smartfactosca.MachineStatusResponse> getGetMachineStatusMethod;
    if ((getGetMachineStatusMethod = MachineMonitoringServiceGrpc.getGetMachineStatusMethod) == null) {
      synchronized (MachineMonitoringServiceGrpc.class) {
        if ((getGetMachineStatusMethod = MachineMonitoringServiceGrpc.getGetMachineStatusMethod) == null) {
          MachineMonitoringServiceGrpc.getGetMachineStatusMethod = getGetMachineStatusMethod =
              io.grpc.MethodDescriptor.<Smartfactosca.MachineStatusRequest, Smartfactosca.MachineStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMachineStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.MachineStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.MachineStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MachineMonitoringServiceMethodDescriptorSupplier("GetMachineStatus"))
              .build();
        }
      }
    }
    return getGetMachineStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Smartfactosca.MaintenanceRequest,
      Smartfactosca.MaintenanceResponse> getInitiateMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitiateMaintenance",
      requestType = Smartfactosca.MaintenanceRequest.class,
      responseType = Smartfactosca.MaintenanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Smartfactosca.MaintenanceRequest,
      Smartfactosca.MaintenanceResponse> getInitiateMaintenanceMethod() {
    io.grpc.MethodDescriptor<Smartfactosca.MaintenanceRequest, Smartfactosca.MaintenanceResponse> getInitiateMaintenanceMethod;
    if ((getInitiateMaintenanceMethod = MachineMonitoringServiceGrpc.getInitiateMaintenanceMethod) == null) {
      synchronized (MachineMonitoringServiceGrpc.class) {
        if ((getInitiateMaintenanceMethod = MachineMonitoringServiceGrpc.getInitiateMaintenanceMethod) == null) {
          MachineMonitoringServiceGrpc.getInitiateMaintenanceMethod = getInitiateMaintenanceMethod =
              io.grpc.MethodDescriptor.<Smartfactosca.MaintenanceRequest, Smartfactosca.MaintenanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitiateMaintenance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.MaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.MaintenanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MachineMonitoringServiceMethodDescriptorSupplier("InitiateMaintenance"))
              .build();
        }
      }
    }
    return getInitiateMaintenanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MachineMonitoringServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineMonitoringServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineMonitoringServiceStub>() {
        @java.lang.Override
        public MachineMonitoringServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineMonitoringServiceStub(channel, callOptions);
        }
      };
    return MachineMonitoringServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MachineMonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineMonitoringServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineMonitoringServiceBlockingStub>() {
        @java.lang.Override
        public MachineMonitoringServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineMonitoringServiceBlockingStub(channel, callOptions);
        }
      };
    return MachineMonitoringServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MachineMonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineMonitoringServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineMonitoringServiceFutureStub>() {
        @java.lang.Override
        public MachineMonitoringServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineMonitoringServiceFutureStub(channel, callOptions);
        }
      };
    return MachineMonitoringServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * MachineMonitoringService definition
   * </pre>
   */
  public static abstract class MachineMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC to get the status of a specific machine
     * </pre>
     */
    public void getMachineStatus(Smartfactosca.MachineStatusRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.MachineStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMachineStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary RPC to initiate maintenance of a machine
     * </pre>
     */
    public void initiateMaintenance(Smartfactosca.MaintenanceRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.MaintenanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitiateMaintenanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMachineStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Smartfactosca.MachineStatusRequest,
                Smartfactosca.MachineStatusResponse>(
                  this, METHODID_GET_MACHINE_STATUS)))
          .addMethod(
            getInitiateMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Smartfactosca.MaintenanceRequest,
                Smartfactosca.MaintenanceResponse>(
                  this, METHODID_INITIATE_MAINTENANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * MachineMonitoringService definition
   * </pre>
   */
  public static final class MachineMonitoringServiceStub extends io.grpc.stub.AbstractAsyncStub<MachineMonitoringServiceStub> {
    private MachineMonitoringServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineMonitoringServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineMonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to get the status of a specific machine
     * </pre>
     */
    public void getMachineStatus(Smartfactosca.MachineStatusRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.MachineStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMachineStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary RPC to initiate maintenance of a machine
     * </pre>
     */
    public void initiateMaintenance(Smartfactosca.MaintenanceRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.MaintenanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitiateMaintenanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * MachineMonitoringService definition
   * </pre>
   */
  public static final class MachineMonitoringServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MachineMonitoringServiceBlockingStub> {
    private MachineMonitoringServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineMonitoringServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to get the status of a specific machine
     * </pre>
     */
    public Smartfactosca.MachineStatusResponse getMachineStatus(Smartfactosca.MachineStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMachineStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary RPC to initiate maintenance of a machine
     * </pre>
     */
    public Smartfactosca.MaintenanceResponse initiateMaintenance(Smartfactosca.MaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitiateMaintenanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * MachineMonitoringService definition
   * </pre>
   */
  public static final class MachineMonitoringServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MachineMonitoringServiceFutureStub> {
    private MachineMonitoringServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineMonitoringServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineMonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to get the status of a specific machine
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Smartfactosca.MachineStatusResponse> getMachineStatus(
        Smartfactosca.MachineStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMachineStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary RPC to initiate maintenance of a machine
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Smartfactosca.MaintenanceResponse> initiateMaintenance(
        Smartfactosca.MaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitiateMaintenanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MACHINE_STATUS = 0;
  private static final int METHODID_INITIATE_MAINTENANCE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MachineMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MachineMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MACHINE_STATUS:
          serviceImpl.getMachineStatus((Smartfactosca.MachineStatusRequest) request,
              (io.grpc.stub.StreamObserver<Smartfactosca.MachineStatusResponse>) responseObserver);
          break;
        case METHODID_INITIATE_MAINTENANCE:
          serviceImpl.initiateMaintenance((Smartfactosca.MaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<Smartfactosca.MaintenanceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MachineMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MachineMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Smartfactosca.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MachineMonitoringService");
    }
  }

  private static final class MachineMonitoringServiceFileDescriptorSupplier
      extends MachineMonitoringServiceBaseDescriptorSupplier {
    MachineMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class MachineMonitoringServiceMethodDescriptorSupplier
      extends MachineMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MachineMonitoringServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MachineMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MachineMonitoringServiceFileDescriptorSupplier())
              .addMethod(getGetMachineStatusMethod())
              .addMethod(getInitiateMaintenanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
