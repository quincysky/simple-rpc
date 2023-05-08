package quincy.registry.zk;

import org.apache.curator.framework.CuratorFramework;
import quincy.registry.ServiceRegistry;
import quincy.registry.zk.util.CuratorUtils;

import java.net.InetSocketAddress;

/**
 * 服务注册类
 * @author quincy
 * @create 2023 - 05 - 08 18:29
 */
public class ZkServiceRegistryImpl implements ServiceRegistry {
    @Override
    public void registerService(String serviceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTRY_PATH + "/" + serviceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
