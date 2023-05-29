package quincy;

import lombok.extern.slf4j.Slf4j;
import quincy.annotation.RpcService;

/**
 * @author quincy
 * @create 2023 - 05 - 29 21:45
 */
@Slf4j
@RpcService(group = "test1", version = "version1")
public class DemoRpcServiceImpl implements DemoRpcService{
    @Override
    public String hello() {
        return "Hello";
    }
}
