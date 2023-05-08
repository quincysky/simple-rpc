package quincy.remoting.transport.socket;

import enums.ServiceDiscoveryEnum;
import exception.RpcException;
import extension.ExtensionLoader;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import quincy.registry.ServiceDiscovery;
import quincy.remoting.dto.RpcRequest;
import quincy.remoting.transport.RpcRequestTransport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author quincy
 * @create 2023 - 05 - 03 19:09
 */
@AllArgsConstructor
@Slf4j
public class SocketRpcClient implements RpcRequestTransport {
    private final ServiceDiscovery serviceDiscovery;

    public SocketRpcClient() {
        this.serviceDiscovery = ExtensionLoader.getExtensionLoader(ServiceDiscovery.class).getExtension(ServiceDiscoveryEnum.ZK.getName());
    }


    @Override
    public Object sendRpcRequest(RpcRequest rpcRequest) {
        InetSocketAddress inetSocketAddress = serviceDiscovery.lookupService(rpcRequest);
        try (Socket socket = new Socket()) {
            socket.connect(inetSocketAddress);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            // 发送数据给服务端
            objectOutputStream.writeObject(rpcRequest);
            return new ObjectInputStream(socket.getInputStream()).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RpcException("调用服务失败：", e);
        }
    }
}
