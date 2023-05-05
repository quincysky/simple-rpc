package quincy.loadbalance.loadbalancer;

import quincy.loadbalance.AbstractLoadBalance;
import quincy.remoting.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 * 随机化选择其中一个
 * @author quincy
 * @create 2023 - 05 - 05 18:54
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceUrlList, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceUrlList.get(random.nextInt(serviceUrlList.size()));
    }
}
