package quincy.remoting.dto;

import lombok.*;

import java.io.ObjectStreamException;

/**
 * @author quincy
 * @create 2023 - 05 - 02 21:16
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcMessage {

    // 消息类型
    private byte messageType;

    // 序列化类型
    private byte codec;

    // 压缩类型
    private byte compress;

    private int requestId;

    // 请求数据
    private Object data;
}
