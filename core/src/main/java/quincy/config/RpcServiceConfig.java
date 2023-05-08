package quincy.config;

import lombok.*;

/**
 * @author quincy
 * @create 2023 - 05 - 08 18:48
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcServiceConfig {

    /**
     * 服务版本号
     */
    private String version = "";

    /**
     * 当接口有多个实现类的时候，通过group进行区分
     */
    private String group = "";

    /**
     * 目标服务
     */
    private Object service;

    public String getRpcServiceName() {
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }

    public String getServiceName() {
        // 返回该类所实现的第一个接口的规范化名称
        return this.service.getClass().getInterfaces()[0].getCanonicalName();
    }
}
