package exception;

/**
 * 序列化异常类
 * @author quincy
 * @create 2023 - 05 - 09 19:12
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String message) {
        super(message);
    }
}
