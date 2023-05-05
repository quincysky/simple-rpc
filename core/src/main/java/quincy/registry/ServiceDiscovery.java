package quincy.registry;

import extension.SPI;
import quincy.remoting.dto.RpcRequest;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 服务发现
 * @author quincy
 * @create 2023 - 05 - 04 21:59
 */
@SPI
public interface ServiceDiscovery {

    /**
     * 通过rpc服务名查找服务
     * <p>
     * InetSocketAddress类是Java中用来表示IP地址和端口号的对象
     * @param rpcRequest
     * @return
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
