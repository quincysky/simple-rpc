package quincy.loadbalance;

import extension.SPI;
import quincy.remoting.dto.RpcRequest;

import java.util.List;

/**
 * 负载均衡策略接口
 *
 * @author quincy
 * @create 2023 - 05 - 05 18:39
 */
@SPI
public interface LoadBalance {

    /**
     * 从根据众多的服务地址中选择一个
     * @param serviceUrlList
     * @param rpcRequest
     * @return
     */
    String selectServiceAddress(List<String> serviceUrlList, RpcRequest rpcRequest);
}
