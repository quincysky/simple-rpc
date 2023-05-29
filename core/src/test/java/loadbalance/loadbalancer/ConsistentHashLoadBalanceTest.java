package loadbalance.loadbalancer;

import extension.ExtensionLoader;
import org.junit.Test;
import quincy.loadbalance.LoadBalance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author quincy
 * @create 2023 - 05 - 26 16:49
 */
public class ConsistentHashLoadBalanceTest {
    @Test
    public void test() {
        LoadBalance loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
        List<String> serviceUrlList = new ArrayList<>(Arrays.asList("127.0.0.1:9997", "127.0.0.1:9998", "127.0.0.1:9999"));


    }
}
