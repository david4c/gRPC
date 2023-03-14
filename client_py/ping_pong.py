import time
import grpc
import ping_pong_pb2
import ping_pong_pb2_grpc


def run():
    with grpc.insecure_channel('localhost:8080') as chanel:
        stab = ping_pong_pb2_grpc.PingPongServiceStub(chanel)

        response = stab.pingPong(ping_pong_pb2.PingRequest(message='Ping', timestamp=int(round(time.time()))))

        print(response)

run()