package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author quincy
 * @create 2023 - 05 - 05 18:06
 */
@AllArgsConstructor
@Getter
public enum RpcConfigEnum {
    RPC_CONFIG_PATH("rpc.properties"),
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyVale;
}
