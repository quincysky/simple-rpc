package quincy.remoting.transport;

import extension.SPI;
import quincy.remoting.dto.RpcRequest;

/**
 * @author quincy
 * @create 2023 - 05 - 03 19:15
 */
@SPI
public interface RpcRequestTransport {

    /**
     * 发送请求到服务器并且获取result
     *
     * @param rpcRequest
     * @return
     */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
