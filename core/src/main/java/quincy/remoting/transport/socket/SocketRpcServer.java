package quincy.remoting.transport.socket;

import factory.SingletonFactory;
import lombok.extern.slf4j.Slf4j;
import quincy.config.CustomShutdownHook;
import quincy.config.RpcServiceConfig;
import quincy.provider.ServiceProvider;
import quincy.provider.impl.ZkServiceProviderImpl;
import quincy.remoting.transport.netty.server.NettyRpcServer;
import sun.nio.ch.ThreadPool;
import utils.concurrent.threadpool.ThreadPoolFactoryUtil;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author quincy
 * @create 2023 - 05 - 08 18:44
 */
@Slf4j
public class SocketRpcServer {

    private final ExecutorService threadPool;
    private final ServiceProvider serviceProvider;

    public SocketRpcServer() {
        threadPool = ThreadPoolFactoryUtil.createCustomThreadPoolIfAbsent("socket-server-rpc-server");
        serviceProvider = SingletonFactory.getInstance(ZkServiceProviderImpl.class);
    }

    public void registerService(RpcServiceConfig rpcServiceConfig) {
        serviceProvider.publishService(rpcServiceConfig);
    }

    public void start() {
        try (ServerSocket server = new ServerSocket()) {
            String host = InetAddress.getLocalHost().getHostAddress();
            server.bind(new InetSocketAddress(host, NettyRpcServer.PORT));
            CustomShutdownHook.getCustomShutdownHook().clearAll();
            Socket socket;
            while ((socket = server.accept())!= null) {
                log.info("socket connected [{}]", socket.getInetAddress());
                threadPool.execute(new SocketRpcRequestHandlerRunnable(socket));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            log.error("occur IOException", e);
        }
    }


}
