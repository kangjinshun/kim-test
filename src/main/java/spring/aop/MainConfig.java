package spring.aop;

import org.springframework.context.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/8/30
 * @since 1.0.0
 */
@EnableAspectJAutoProxy
@Configuration
@Import({MathCal.class})
public class MainConfig {
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}




