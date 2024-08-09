package factory;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Machine Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: machine_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MachineServiceGrpc {

  private MachineServiceGrpc() {}

  public static final String SERVICE_NAME = "factory.MachineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.MachineStatusRequest,
      factory.MachineServiceOuterClass.MachineStatusResponse> getGetMachineStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMachineStatus",
      requestType = factory.MachineServiceOuterClass.MachineStatusRequest.class,
      responseType = factory.MachineServiceOuterClass.MachineStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.MachineStatusRequest,
      factory.MachineServiceOuterClass.MachineStatusResponse> getGetMachineStatusMethod() {
    io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.MachineStatusRequest, factory.MachineServiceOuterClass.MachineStatusResponse> getGetMachineStatusMethod;
    if ((getGetMachineStatusMethod = MachineServiceGrpc.getGetMachineStatusMethod) == null) {
      synchronized (MachineServiceGrpc.class) {
        if ((getGetMachineStatusMethod = MachineServiceGrpc.getGetMachineStatusMethod) == null) {
          MachineServiceGrpc.getGetMachineStatusMethod = getGetMachineStatusMethod =
              io.grpc.MethodDescriptor.<factory.MachineServiceOuterClass.MachineStatusRequest, factory.MachineServiceOuterClass.MachineStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMachineStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.MachineStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.MachineStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MachineServiceMethodDescriptorSupplier("GetMachineStatus"))
              .build();
        }
      }
    }
    return getGetMachineStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.MaintenanceRequest,
      factory.MachineServiceOuterClass.MaintenanceResponse> getInitiateMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitiateMaintenance",
      requestType = factory.MachineServiceOuterClass.MaintenanceRequest.class,
      responseType = factory.MachineServiceOuterClass.MaintenanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.MaintenanceRequest,
      factory.MachineServiceOuterClass.MaintenanceResponse> getInitiateMaintenanceMethod() {
    io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.MaintenanceRequest, factory.MachineServiceOuterClass.MaintenanceResponse> getInitiateMaintenanceMethod;
    if ((getInitiateMaintenanceMethod = MachineServiceGrpc.getInitiateMaintenanceMethod) == null) {
      synchronized (MachineServiceGrpc.class) {
        if ((getInitiateMaintenanceMethod = MachineServiceGrpc.getInitiateMaintenanceMethod) == null) {
          MachineServiceGrpc.getInitiateMaintenanceMethod = getInitiateMaintenanceMethod =
              io.grpc.MethodDescriptor.<factory.MachineServiceOuterClass.MaintenanceRequest, factory.MachineServiceOuterClass.MaintenanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitiateMaintenance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.MaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.MaintenanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MachineServiceMethodDescriptorSupplier("InitiateMaintenance"))
              .build();
        }
      }
    }
    return getInitiateMaintenanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MachineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineServiceStub>() {
        @java.lang.Override
        public MachineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineServiceStub(channel, callOptions);
        }
      };
    return MachineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MachineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineServiceBlockingStub>() {
        @java.lang.Override
        public MachineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineServiceBlockingStub(channel, callOptions);
        }
      };
    return MachineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MachineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineServiceFutureStub>() {
        @java.lang.Override
        public MachineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineServiceFutureStub(channel, callOptions);
        }
      };
    return MachineServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Machine Service definition
   * </pre>
   */
  public static abstract class MachineServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC for getting machine status
     * </pre>
     */
    public void getMachineStatus(factory.MachineServiceOuterClass.MachineStatusRequest request,
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.MachineStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMachineStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary RPC for initiating maintenance
     * </pre>
     */
    public void initiateMaintenance(factory.MachineServiceOuterClass.MaintenanceRequest request,
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.MaintenanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitiateMaintenanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMachineStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                factory.MachineServiceOuterClass.MachineStatusRequest,
                factory.MachineServiceOuterClass.MachineStatusResponse>(
                  this, METHODID_GET_MACHINE_STATUS)))
          .addMethod(
            getInitiateMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                factory.MachineServiceOuterClass.MaintenanceRequest,
                factory.MachineServiceOuterClass.MaintenanceResponse>(
                  this, METHODID_INITIATE_MAINTENANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * Machine Service definition
   * </pre>
   */
  public static final class MachineServiceStub extends io.grpc.stub.AbstractAsyncStub<MachineServiceStub> {
    private MachineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting machine status
     * </pre>
     */
    public void getMachineStatus(factory.MachineServiceOuterClass.MachineStatusRequest request,
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.MachineStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMachineStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary RPC for initiating maintenance
     * </pre>
     */
    public void initiateMaintenance(factory.MachineServiceOuterClass.MaintenanceRequest request,
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.MaintenanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitiateMaintenanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Machine Service definition
   * </pre>
   */
  public static final class MachineServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MachineServiceBlockingStub> {
    private MachineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting machine status
     * </pre>
     */
    public factory.MachineServiceOuterClass.MachineStatusResponse getMachineStatus(factory.MachineServiceOuterClass.MachineStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMachineStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary RPC for initiating maintenance
     * </pre>
     */
    public factory.MachineServiceOuterClass.MaintenanceResponse initiateMaintenance(factory.MachineServiceOuterClass.MaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitiateMaintenanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Machine Service definition
   * </pre>
   */
  public static final class MachineServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MachineServiceFutureStub> {
    private MachineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting machine status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<factory.MachineServiceOuterClass.MachineStatusResponse> getMachineStatus(
        factory.MachineServiceOuterClass.MachineStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMachineStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary RPC for initiating maintenance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<factory.MachineServiceOuterClass.MaintenanceResponse> initiateMaintenance(
        factory.MachineServiceOuterClass.MaintenanceRequest request) {
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
    private final MachineServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MachineServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MACHINE_STATUS:
          serviceImpl.getMachineStatus((factory.MachineServiceOuterClass.MachineStatusRequest) request,
              (io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.MachineStatusResponse>) responseObserver);
          break;
        case METHODID_INITIATE_MAINTENANCE:
          serviceImpl.initiateMaintenance((factory.MachineServiceOuterClass.MaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.MaintenanceResponse>) responseObserver);
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

  private static abstract class MachineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MachineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return factory.MachineServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MachineService");
    }
  }

  private static final class MachineServiceFileDescriptorSupplier
      extends MachineServiceBaseDescriptorSupplier {
    MachineServiceFileDescriptorSupplier() {}
  }

  private static final class MachineServiceMethodDescriptorSupplier
      extends MachineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MachineServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MachineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MachineServiceFileDescriptorSupplier())
              .addMethod(getGetMachineStatusMethod())
              .addMethod(getInitiateMaintenanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
