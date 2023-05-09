package quincy.serialize;

import extension.SPI;

/**
 * 序列化接口，所有序列化类都要实现这个接口
 * @author quincy
 * @create 2023 - 05 - 09 18:49
 */
@SPI
public interface Serializer {

    /**
     * 序列化
     * @param object 要序列化的对象
     * @return 字节数组
     */
    byte[] serialize(Object object);

    /**
     * 反序列化
     * @param bytes 序列化后的字节数组
     * @param clazz 目标类
     * @param <T>
     * @return 反序列化的对象
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
