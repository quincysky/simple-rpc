package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author quincy
 * @create 2023 - 05 - 02 21:34
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCodeEnum {

    SUCCESS(200, "The remote call is success"),
    FAIL(500, "The remote call is fail");

    private final int code;

    private final String message;
}
