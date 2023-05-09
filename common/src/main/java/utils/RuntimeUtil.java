package utils;

/**
 * @author quincy
 * @create 2023 - 05 - 09 19:37
 */
public class RuntimeUtil {

    /**
     * 获取CPU的核心数
     * @return
     */
    public static int cpus() {
        return Runtime.getRuntime().availableProcessors();
    }
}
