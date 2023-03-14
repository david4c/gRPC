package org.example;

import com.example.grpc.PingPongServiceGrpc;
import com.example.grpc.PingPongServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class App {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                                                      .usePlaintext()
                                                      .build();

        final PingPongServiceGrpc.PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);

        final PingPongServiceOuterClass.PingRequest request = PingPongServiceOuterClass.PingRequest.newBuilder()
                                                                                                   .setMessage("Ping")
                                                                                                   .setTimestamp(System.currentTimeMillis())
                                                                                                   .build();

        final PingPongServiceOuterClass.PongResponse response = stub.pingPong(request);
        System.out.println(response);
        channel.shutdownNow();
    }
}
