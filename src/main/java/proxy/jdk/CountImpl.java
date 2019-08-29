package proxy.jdk;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/8/28
 * @since 1.0.0
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("queryCount被调用");
    }

    @Override
    public void updateCount() {
        System.out.println("updateCount被调用");
    }
}
