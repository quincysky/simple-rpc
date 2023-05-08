package quincy.provider;

import quincy.config.RpcServiceConfig;

/**
 * 存储并且提供服务对象
 * @author quincy
 * @create 2023 - 05 - 08 20:52
 */
public interface ServiceProvider {

    void addService(RpcServiceConfig rpcServiceConfig);

    Object getService(String rpcServiceName);

    void publishService(RpcServiceConfig rpcServiceConfig);
}
