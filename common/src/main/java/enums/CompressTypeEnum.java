package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author quincy
 * @create 2023 - 05 - 18 20:52
 */
@AllArgsConstructor
@Getter
public enum CompressTypeEnum {

    GZIP((byte) 0x01, "gzip");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (CompressTypeEnum c : CompressTypeEnum.values()) {
            if (c.code == code) {
                return c.name;
            }
        }
        return null;
    }
}
