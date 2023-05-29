package quincy.annotation;

import java.lang.annotation.*;

/**
 * @author quincy
 * @create 2023 - 05 - 29 21:46
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {

    /**
     * 服务版本，默认为空
     * @return
     */
    String version() default "";

    /**
     * 服务组，默认为空
     * @return
     */
    String group() default "";
}
