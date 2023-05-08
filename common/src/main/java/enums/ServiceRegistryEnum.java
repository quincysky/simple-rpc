package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author quincy
 * @create 2023 - 05 - 08 20:59
 */
@AllArgsConstructor
@Getter
public enum ServiceRegistryEnum {

    ZK("zk");

    private final String name;
}
