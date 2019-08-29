package proxy.jdk;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/8/28
 * @since 1.0.0
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        Count instance = new CountImpl();
        Count proxy = new JdkProxy(instance).getProxy();
        proxy.queryCount();
        proxy.updateCount();
    }
}
