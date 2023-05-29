package utils;

/**
 * @author quincy
 * @create 2023 - 05 - 25 21:39
 */
public class StringUtils {

    public static boolean isBlank(String s) {
        if (s == null || s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
