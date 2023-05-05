package quincy.registry.zk;

import quincy.loadbalance.LoadBalance;
import quincy.remoting.dto.RpcRequest;
import quincy.registry.ServiceDiscovery;

import java.net.InetSocketAddress;

/**
 * @author quincy
 * @create 2023 - 05 - 04 22:13
 */
public class ZkServiceDiscoveryImpl implements ServiceDiscovery {

    // 负载均衡策略
    private final LoadBalance loadBalance;

    public ZkServiceDiscoveryImpl() {

    }

    @Override
    public InetSocketAddress lookupService(RpcRequest rpcRequest) {
        return null;
    }
}
