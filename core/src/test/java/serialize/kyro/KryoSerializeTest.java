package serialize.kyro;

import lombok.ToString;
import org.junit.Test;
import quincy.remoting.dto.RpcRequest;
import quincy.serialize.kryo.KryoSerializer;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author quincy
 * @create 2023 - 05 - 25 21:20
 */
public class KryoSerializeTest {
    @Test
    public void kryoSerializeTest() {
        RpcRequest target = RpcRequest.builder().methodName("hello")
                .parameters(new Object[]{"sayhelloloo", "sayheloo"})
                .interfaceName("quincy.helloservice")
                .paramTypes(new Class[]{String.class, String.class})
                .requestId(UUID.randomUUID().toString())
                .group("group1")
                .version("version1")
                .build();
        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] bytes = kryoSerializer.serialize(target);
        RpcRequest actual = kryoSerializer.deserialize(bytes, RpcRequest.class);
        assertEquals(target.getGroup(), actual.getGroup());
        assertEquals(target.getVersion(), actual.getVersion());
        assertEquals(target.getRequestId(), actual.getRequestId());
    }
}
