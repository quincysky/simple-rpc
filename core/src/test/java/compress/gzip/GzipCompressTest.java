package compress.gzip;

import org.junit.Test;
import quincy.compress.gzip.GzipCompress;
import quincy.remoting.dto.RpcRequest;
import quincy.serialize.kryo.KryoSerializer;

import java.util.UUID;

/**
 * @author quincy
 * @create 2023 - 05 - 26 16:45
 */
public class GzipCompressTest {

    @Test
    public void gzipCompress() {
        GzipCompress gzipCompress = new GzipCompress();
        RpcRequest rpcRequest = RpcRequest.builder().methodName("hello")
                .parameters(new Object[]{"sayhelooloo", "sayhelooloosayhelooloo"})
                .interfaceName("github.javaguide.HelloService")
                .paramTypes(new Class<?>[]{String.class, String.class})
                .requestId(UUID.randomUUID().toString())
                .group("group1")
                .version("version1")
                .build();
        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] rpcRequestBytes = kryoSerializer.serialize(rpcRequest);
        byte[] compressRpcRequestBytes = gzipCompress.compress(rpcRequestBytes);
        byte[] decompress = gzipCompress.decompress(compressRpcRequestBytes);
        assert rpcRequestBytes.length == decompress.length;
    }
}
