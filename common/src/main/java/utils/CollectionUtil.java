package utils;

import java.util.Collection;

/**
 * 集合工具类
 * @author quincy
 * @create 2023 - 05 - 05 18:45
 */
public class CollectionUtil {

    public static Boolean isEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }
}
