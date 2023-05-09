package quincy.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import exception.SerializeException;
import lombok.extern.slf4j.Slf4j;
import quincy.remoting.dto.RpcRequest;
import quincy.remoting.dto.RpcResponse;
import quincy.serialize.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Kryo序列化类是仅适用于Java语言的高性能序列化类
 * @author quincy
 * @create 2023 - 05 - 09 18:53
 */
@Slf4j
public class KryoSerializer implements Serializer {

    /**
     * 因为Kryo不是线程安全的，因此使用ThreadLocal来存储Kryo对象
     */
    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> {
        Kryo kryo = new Kryo();
        kryo.register(RpcRequest.class);
        kryo.register(RpcResponse.class);
        return kryo;
    });

    @Override
    public byte[] serialize(Object object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            kryo.writeObject(output, object);
            // 此处由于对应的对象是强引用，为避免内存泄漏，手动删除
            kryoThreadLocal.remove();
            return output.toBytes();
        } catch (Exception e) {
            throw new SerializeException("Serialization failed");
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayOutputStream = new ByteArrayInputStream(bytes);
             Input input = new Input(byteArrayOutputStream)) {
            Object o = kryoThreadLocal.get().readObject(input, clazz);
            kryoThreadLocal.remove();
            // 将Object对象强制转换成clazz表示的类或接口
            return clazz.cast(o);
        } catch (IOException e) {
            throw new SerializeException("Deserialization failed");
        }
    }
}
