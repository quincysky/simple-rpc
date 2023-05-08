package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author quincy
 * @create 2023 - 05 - 08 21:43
 */
@AllArgsConstructor
@Getter
public enum ServiceDiscoveryEnum {

    ZK("zk");

    private final String name;
}
