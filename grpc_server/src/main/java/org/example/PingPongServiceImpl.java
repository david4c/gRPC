package org.example;

import com.example.grpc.PingPongServiceGrpc;
import com.example.grpc.PingPongServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void pingPong(
            final PingPongServiceOuterClass.PingRequest request,
            final StreamObserver<PingPongServiceOuterClass.PongResponse> responseObserver
    ) {
        System.out.println(request);

        final PingPongServiceOuterClass.PongResponse response = PingPongServiceOuterClass.PongResponse.newBuilder()
                                                                                                      .setMessage("Pong")
                                                                                                      .setTimestamp(System.currentTimeMillis())
                                                                                                      .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
