package quincy.registry;

import extension.SPI;

import java.net.InetSocketAddress;

/**
 * 服务注册
 * @author quincy
 * @create 2023 - 05 - 04 22:05
 */
@SPI
public interface ServiceRegistry {

    /**
     * 注册服务
     * @param serviceName
     * @param inetSocketAddress
     */
    void registerService(String serviceName, InetSocketAddress inetSocketAddress);
}
