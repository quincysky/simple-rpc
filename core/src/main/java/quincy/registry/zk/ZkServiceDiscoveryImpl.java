package quincy.registry.zk;

import enums.LoadBalanceEnum;
import enums.RpcErrorMessageEnum;
import exception.RpcException;
import extension.ExtensionLoader;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import quincy.loadbalance.LoadBalance;
import quincy.registry.zk.util.CuratorUtils;
import quincy.remoting.dto.RpcRequest;
import quincy.registry.ServiceDiscovery;
import utils.CollectionUtil;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author quincy
 * @create 2023 - 05 - 04 22:13
 */
@Slf4j
public class ZkServiceDiscoveryImpl implements ServiceDiscovery {

    // 负载均衡策略
    private final LoadBalance loadBalance;

    public ZkServiceDiscoveryImpl() {
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(LoadBalanceEnum.LOADBALANCE.getName());
    }

    /**
     * 查找服务
     * @param rpcRequest
     * @return
     */
    @Override
    public InetSocketAddress lookupService(RpcRequest rpcRequest) {
        String rpcServiceName = rpcRequest.getRpcServiceName();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if (CollectionUtil.isEmpty(serviceUrlList)) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, rpcServiceName);
        }
        // 负载均衡，根据负载均衡算法查找一个服务
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, rpcRequest);
        log.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
