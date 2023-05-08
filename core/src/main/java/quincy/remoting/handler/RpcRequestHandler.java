package quincy.remoting.handler;

import exception.RpcException;
import factory.SingletonFactory;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;
import quincy.provider.ServiceProvider;
import quincy.provider.impl.ZkServiceProviderImpl;
import quincy.remoting.dto.RpcRequest;

/**
 * RPC请求处理器
 * @author quincy
 * @create 2023 - 05 - 08 21:27
 */
@Slf4j
public class RpcRequestHandler {
    private final ServiceProvider serviceProvider;

    public RpcRequestHandler() {
        serviceProvider = SingletonFactory.getInstance(ZkServiceProviderImpl.class);
    }

    /**
     * 处理rpc请求，调用响应的方法然后返回该方法返回值
     * @param request
     * @return
     */
    public Object handle(RpcRequest request) {
        Object service = serviceProvider.getService(request.getRpcServiceName());
        return invokeTargetMethod(request, service);
    }

    private Object invokeTargetMethod(RpcRequest rpcRequest, Object service) {
        Object result;
        try {
            result = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamTypes()).invoke(service, rpcRequest.getParameters());
            log.info("service:[{}] successful invoke method:[{}]", rpcRequest.getInterfaceName(), rpcRequest.getMethodName());
        } catch (Exception e) {
            throw new RpcException(e.getMessage(), e);
        }
        return result;
    }
}
