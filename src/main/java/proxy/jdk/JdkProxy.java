package proxy.jdk;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/8/28
 * @since 1.0.0
 */
public class JdkProxy {
    // 被代理对象
    private Count obj;

    public JdkProxy(Count obj) {
        this.obj = obj;
    }

    public Count getProxy() {
        /**
         *  加载类
         *  接口
         *  重写InvocationHandler接口的invoke方法
         */
        return (Count) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Count.class},
                (Object proxy, Method method, Object[] args) -> {
                    String s = method.getName();
                    System.out.println("调用" + s + "方法前");
                    Object invoke = method.invoke(obj, args);
                    System.out.println("调用" + s + "方法后");
                    return invoke;
                });

    }
}
