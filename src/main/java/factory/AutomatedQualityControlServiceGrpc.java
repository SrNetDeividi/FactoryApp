package factory;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Automated Quality Control Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: machine_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutomatedQualityControlServiceGrpc {

  private AutomatedQualityControlServiceGrpc() {}

  public static final String SERVICE_NAME = "factory.AutomatedQualityControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.QualityInspectionRequest,
      factory.MachineServiceOuterClass.QualityInspectionSummaryResponse> getSendQualityInspectionResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendQualityInspectionResults",
      requestType = factory.MachineServiceOuterClass.QualityInspectionRequest.class,
      responseType = factory.MachineServiceOuterClass.QualityInspectionSummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.QualityInspectionRequest,
      factory.MachineServiceOuterClass.QualityInspectionSummaryResponse> getSendQualityInspectionResultsMethod() {
    io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.QualityInspectionRequest, factory.MachineServiceOuterClass.QualityInspectionSummaryResponse> getSendQualityInspectionResultsMethod;
    if ((getSendQualityInspectionResultsMethod = AutomatedQualityControlServiceGrpc.getSendQualityInspectionResultsMethod) == null) {
      synchronized (AutomatedQualityControlServiceGrpc.class) {
        if ((getSendQualityInspectionResultsMethod = AutomatedQualityControlServiceGrpc.getSendQualityInspectionResultsMethod) == null) {
          AutomatedQualityControlServiceGrpc.getSendQualityInspectionResultsMethod = getSendQualityInspectionResultsMethod =
              io.grpc.MethodDescriptor.<factory.MachineServiceOuterClass.QualityInspectionRequest, factory.MachineServiceOuterClass.QualityInspectionSummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendQualityInspectionResults"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.QualityInspectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.QualityInspectionSummaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AutomatedQualityControlServiceMethodDescriptorSupplier("SendQualityInspectionResults"))
              .build();
        }
      }
    }
    return getSendQualityInspectionResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.QualityInspectionRequest,
      factory.MachineServiceOuterClass.QualityFeedbackResponse> getRealTimeQualityFeedbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RealTimeQualityFeedback",
      requestType = factory.MachineServiceOuterClass.QualityInspectionRequest.class,
      responseType = factory.MachineServiceOuterClass.QualityFeedbackResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.QualityInspectionRequest,
      factory.MachineServiceOuterClass.QualityFeedbackResponse> getRealTimeQualityFeedbackMethod() {
    io.grpc.MethodDescriptor<factory.MachineServiceOuterClass.QualityInspectionRequest, factory.MachineServiceOuterClass.QualityFeedbackResponse> getRealTimeQualityFeedbackMethod;
    if ((getRealTimeQualityFeedbackMethod = AutomatedQualityControlServiceGrpc.getRealTimeQualityFeedbackMethod) == null) {
      synchronized (AutomatedQualityControlServiceGrpc.class) {
        if ((getRealTimeQualityFeedbackMethod = AutomatedQualityControlServiceGrpc.getRealTimeQualityFeedbackMethod) == null) {
          AutomatedQualityControlServiceGrpc.getRealTimeQualityFeedbackMethod = getRealTimeQualityFeedbackMethod =
              io.grpc.MethodDescriptor.<factory.MachineServiceOuterClass.QualityInspectionRequest, factory.MachineServiceOuterClass.QualityFeedbackResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RealTimeQualityFeedback"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.QualityInspectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  factory.MachineServiceOuterClass.QualityFeedbackResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AutomatedQualityControlServiceMethodDescriptorSupplier("RealTimeQualityFeedback"))
              .build();
        }
      }
    }
    return getRealTimeQualityFeedbackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutomatedQualityControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomatedQualityControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutomatedQualityControlServiceStub>() {
        @java.lang.Override
        public AutomatedQualityControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutomatedQualityControlServiceStub(channel, callOptions);
        }
      };
    return AutomatedQualityControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutomatedQualityControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomatedQualityControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutomatedQualityControlServiceBlockingStub>() {
        @java.lang.Override
        public AutomatedQualityControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutomatedQualityControlServiceBlockingStub(channel, callOptions);
        }
      };
    return AutomatedQualityControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutomatedQualityControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomatedQualityControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutomatedQualityControlServiceFutureStub>() {
        @java.lang.Override
        public AutomatedQualityControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutomatedQualityControlServiceFutureStub(channel, callOptions);
        }
      };
    return AutomatedQualityControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Automated Quality Control Service definition
   * </pre>
   */
  public static abstract class AutomatedQualityControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client streaming RPC for sending quality inspection results
     * </pre>
     */
    public io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionRequest> sendQualityInspectionResults(
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionSummaryResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendQualityInspectionResultsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming RPC for real-time quality feedback
     * </pre>
     */
    public io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionRequest> realTimeQualityFeedback(
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityFeedbackResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getRealTimeQualityFeedbackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendQualityInspectionResultsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                factory.MachineServiceOuterClass.QualityInspectionRequest,
                factory.MachineServiceOuterClass.QualityInspectionSummaryResponse>(
                  this, METHODID_SEND_QUALITY_INSPECTION_RESULTS)))
          .addMethod(
            getRealTimeQualityFeedbackMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                factory.MachineServiceOuterClass.QualityInspectionRequest,
                factory.MachineServiceOuterClass.QualityFeedbackResponse>(
                  this, METHODID_REAL_TIME_QUALITY_FEEDBACK)))
          .build();
    }
  }

  /**
   * <pre>
   * Automated Quality Control Service definition
   * </pre>
   */
  public static final class AutomatedQualityControlServiceStub extends io.grpc.stub.AbstractAsyncStub<AutomatedQualityControlServiceStub> {
    private AutomatedQualityControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomatedQualityControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomatedQualityControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client streaming RPC for sending quality inspection results
     * </pre>
     */
    public io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionRequest> sendQualityInspectionResults(
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionSummaryResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendQualityInspectionResultsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming RPC for real-time quality feedback
     * </pre>
     */
    public io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionRequest> realTimeQualityFeedback(
        io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityFeedbackResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getRealTimeQualityFeedbackMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Automated Quality Control Service definition
   * </pre>
   */
  public static final class AutomatedQualityControlServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AutomatedQualityControlServiceBlockingStub> {
    private AutomatedQualityControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomatedQualityControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomatedQualityControlServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Automated Quality Control Service definition
   * </pre>
   */
  public static final class AutomatedQualityControlServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AutomatedQualityControlServiceFutureStub> {
    private AutomatedQualityControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomatedQualityControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomatedQualityControlServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_QUALITY_INSPECTION_RESULTS = 0;
  private static final int METHODID_REAL_TIME_QUALITY_FEEDBACK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutomatedQualityControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutomatedQualityControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_QUALITY_INSPECTION_RESULTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendQualityInspectionResults(
              (io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityInspectionSummaryResponse>) responseObserver);
        case METHODID_REAL_TIME_QUALITY_FEEDBACK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.realTimeQualityFeedback(
              (io.grpc.stub.StreamObserver<factory.MachineServiceOuterClass.QualityFeedbackResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AutomatedQualityControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutomatedQualityControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return factory.MachineServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutomatedQualityControlService");
    }
  }

  private static final class AutomatedQualityControlServiceFileDescriptorSupplier
      extends AutomatedQualityControlServiceBaseDescriptorSupplier {
    AutomatedQualityControlServiceFileDescriptorSupplier() {}
  }

  private static final class AutomatedQualityControlServiceMethodDescriptorSupplier
      extends AutomatedQualityControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutomatedQualityControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AutomatedQualityControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AutomatedQualityControlServiceFileDescriptorSupplier())
              .addMethod(getSendQualityInspectionResultsMethod())
              .addMethod(getRealTimeQualityFeedbackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
