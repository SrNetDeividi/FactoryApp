import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * AssemblyLineDataService definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: smartfactosca.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssemblyLineDataServiceGrpc {

  private AssemblyLineDataServiceGrpc() {}

  public static final String SERVICE_NAME = "AssemblyLineDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Smartfactosca.AssemblyLineDataRequest,
      Smartfactosca.AssemblyLineDataResponse> getStreamAssemblyLineDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamAssemblyLineData",
      requestType = Smartfactosca.AssemblyLineDataRequest.class,
      responseType = Smartfactosca.AssemblyLineDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Smartfactosca.AssemblyLineDataRequest,
      Smartfactosca.AssemblyLineDataResponse> getStreamAssemblyLineDataMethod() {
    io.grpc.MethodDescriptor<Smartfactosca.AssemblyLineDataRequest, Smartfactosca.AssemblyLineDataResponse> getStreamAssemblyLineDataMethod;
    if ((getStreamAssemblyLineDataMethod = AssemblyLineDataServiceGrpc.getStreamAssemblyLineDataMethod) == null) {
      synchronized (AssemblyLineDataServiceGrpc.class) {
        if ((getStreamAssemblyLineDataMethod = AssemblyLineDataServiceGrpc.getStreamAssemblyLineDataMethod) == null) {
          AssemblyLineDataServiceGrpc.getStreamAssemblyLineDataMethod = getStreamAssemblyLineDataMethod =
              io.grpc.MethodDescriptor.<Smartfactosca.AssemblyLineDataRequest, Smartfactosca.AssemblyLineDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamAssemblyLineData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.AssemblyLineDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.AssemblyLineDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AssemblyLineDataServiceMethodDescriptorSupplier("StreamAssemblyLineData"))
              .build();
        }
      }
    }
    return getStreamAssemblyLineDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Smartfactosca.StartAssemblyLineRequest,
      Smartfactosca.StartAssemblyLineResponse> getStartAssemblyLineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartAssemblyLine",
      requestType = Smartfactosca.StartAssemblyLineRequest.class,
      responseType = Smartfactosca.StartAssemblyLineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Smartfactosca.StartAssemblyLineRequest,
      Smartfactosca.StartAssemblyLineResponse> getStartAssemblyLineMethod() {
    io.grpc.MethodDescriptor<Smartfactosca.StartAssemblyLineRequest, Smartfactosca.StartAssemblyLineResponse> getStartAssemblyLineMethod;
    if ((getStartAssemblyLineMethod = AssemblyLineDataServiceGrpc.getStartAssemblyLineMethod) == null) {
      synchronized (AssemblyLineDataServiceGrpc.class) {
        if ((getStartAssemblyLineMethod = AssemblyLineDataServiceGrpc.getStartAssemblyLineMethod) == null) {
          AssemblyLineDataServiceGrpc.getStartAssemblyLineMethod = getStartAssemblyLineMethod =
              io.grpc.MethodDescriptor.<Smartfactosca.StartAssemblyLineRequest, Smartfactosca.StartAssemblyLineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartAssemblyLine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.StartAssemblyLineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Smartfactosca.StartAssemblyLineResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AssemblyLineDataServiceMethodDescriptorSupplier("StartAssemblyLine"))
              .build();
        }
      }
    }
    return getStartAssemblyLineMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AssemblyLineDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssemblyLineDataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AssemblyLineDataServiceStub>() {
        @java.lang.Override
        public AssemblyLineDataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AssemblyLineDataServiceStub(channel, callOptions);
        }
      };
    return AssemblyLineDataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssemblyLineDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssemblyLineDataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AssemblyLineDataServiceBlockingStub>() {
        @java.lang.Override
        public AssemblyLineDataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AssemblyLineDataServiceBlockingStub(channel, callOptions);
        }
      };
    return AssemblyLineDataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AssemblyLineDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssemblyLineDataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AssemblyLineDataServiceFutureStub>() {
        @java.lang.Override
        public AssemblyLineDataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AssemblyLineDataServiceFutureStub(channel, callOptions);
        }
      };
    return AssemblyLineDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * AssemblyLineDataService definition
   * </pre>
   */
  public static abstract class AssemblyLineDataServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server streaming RPC to send real-time data about the assembly line
     * </pre>
     */
    public void streamAssemblyLineData(Smartfactosca.AssemblyLineDataRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.AssemblyLineDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamAssemblyLineDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary RPC to start a specific assembly line
     * </pre>
     */
    public void startAssemblyLine(Smartfactosca.StartAssemblyLineRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.StartAssemblyLineResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartAssemblyLineMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamAssemblyLineDataMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                Smartfactosca.AssemblyLineDataRequest,
                Smartfactosca.AssemblyLineDataResponse>(
                  this, METHODID_STREAM_ASSEMBLY_LINE_DATA)))
          .addMethod(
            getStartAssemblyLineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Smartfactosca.StartAssemblyLineRequest,
                Smartfactosca.StartAssemblyLineResponse>(
                  this, METHODID_START_ASSEMBLY_LINE)))
          .build();
    }
  }

  /**
   * <pre>
   * AssemblyLineDataService definition
   * </pre>
   */
  public static final class AssemblyLineDataServiceStub extends io.grpc.stub.AbstractAsyncStub<AssemblyLineDataServiceStub> {
    private AssemblyLineDataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssemblyLineDataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssemblyLineDataServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server streaming RPC to send real-time data about the assembly line
     * </pre>
     */
    public void streamAssemblyLineData(Smartfactosca.AssemblyLineDataRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.AssemblyLineDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamAssemblyLineDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary RPC to start a specific assembly line
     * </pre>
     */
    public void startAssemblyLine(Smartfactosca.StartAssemblyLineRequest request,
        io.grpc.stub.StreamObserver<Smartfactosca.StartAssemblyLineResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartAssemblyLineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * AssemblyLineDataService definition
   * </pre>
   */
  public static final class AssemblyLineDataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AssemblyLineDataServiceBlockingStub> {
    private AssemblyLineDataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssemblyLineDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssemblyLineDataServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server streaming RPC to send real-time data about the assembly line
     * </pre>
     */
    public java.util.Iterator<Smartfactosca.AssemblyLineDataResponse> streamAssemblyLineData(
        Smartfactosca.AssemblyLineDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamAssemblyLineDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary RPC to start a specific assembly line
     * </pre>
     */
    public Smartfactosca.StartAssemblyLineResponse startAssemblyLine(Smartfactosca.StartAssemblyLineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartAssemblyLineMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * AssemblyLineDataService definition
   * </pre>
   */
  public static final class AssemblyLineDataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AssemblyLineDataServiceFutureStub> {
    private AssemblyLineDataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssemblyLineDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssemblyLineDataServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC to start a specific assembly line
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Smartfactosca.StartAssemblyLineResponse> startAssemblyLine(
        Smartfactosca.StartAssemblyLineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartAssemblyLineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_ASSEMBLY_LINE_DATA = 0;
  private static final int METHODID_START_ASSEMBLY_LINE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssemblyLineDataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssemblyLineDataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_ASSEMBLY_LINE_DATA:
          serviceImpl.streamAssemblyLineData((Smartfactosca.AssemblyLineDataRequest) request,
              (io.grpc.stub.StreamObserver<Smartfactosca.AssemblyLineDataResponse>) responseObserver);
          break;
        case METHODID_START_ASSEMBLY_LINE:
          serviceImpl.startAssemblyLine((Smartfactosca.StartAssemblyLineRequest) request,
              (io.grpc.stub.StreamObserver<Smartfactosca.StartAssemblyLineResponse>) responseObserver);
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

  private static abstract class AssemblyLineDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssemblyLineDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Smartfactosca.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssemblyLineDataService");
    }
  }

  private static final class AssemblyLineDataServiceFileDescriptorSupplier
      extends AssemblyLineDataServiceBaseDescriptorSupplier {
    AssemblyLineDataServiceFileDescriptorSupplier() {}
  }

  private static final class AssemblyLineDataServiceMethodDescriptorSupplier
      extends AssemblyLineDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AssemblyLineDataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AssemblyLineDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AssemblyLineDataServiceFileDescriptorSupplier())
              .addMethod(getStreamAssemblyLineDataMethod())
              .addMethod(getStartAssemblyLineMethod())
              .build();
        }
      }
    }
    return result;
  }
}
