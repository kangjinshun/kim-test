package spring.aop;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/8/30
 * @since 1.0.0
 */
public class MathCal {
    public int div(int i, int j) {
        System.out.println("div 方法");
        return i / j;
    }

    public int add(int i, int j) {
        System.out.println("add 方法");
        return i + j;
    }
}
