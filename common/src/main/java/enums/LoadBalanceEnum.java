package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author quincy
 * @create 2023 - 05 - 05 20:13
 */
@AllArgsConstructor
@Getter
public enum LoadBalanceEnum {
    LOADBALANCE("loadBalance");

    private final String name;
}
