package plugin.compile;

/**
 * 非规范命名代码测试类<br>
 * javac -encoding utf-8 plugin/compile/NameChecker.java
 * javac -encoding utf-8 plugin/compile/NameCheckProcessor.java
 * javac -encoding utf-8 -processor  plugin.compile.NameCheckProcessor plugin/compile/BADLY_NAME_CODE.java
 * ================结果如下
 * plugin\compile\BADLY_NAME_CODE.java:10: 警告: 名称BADLY_NAME_CODE应当符合驼峰式命名法
 * public class BADLY_NAME_CODE {
 *        ^
 * plugin\compile\BADLY_NAME_CODE.java:11: 警告: 名称colors应当以大写字母开头
 *     enum colors {
 *     ^
 * plugin\compile\BADLY_NAME_CODE.java:12: 警告: 常量red应当全部大写字母或下划线命名，并以字母开头
 *         red, blue, green;
 *         ^
 * plugin\compile\BADLY_NAME_CODE.java:12: 警告: 常量blue应当全部大写字母或下划线命名，并以字母开头
 *         red, blue, green;
 *              ^
 * plugin\compile\BADLY_NAME_CODE.java:12: 警告: 常量green应当全部大写字母或下划线命名，并以字母开头
 *         red, blue, green;
 *                    ^
 * plugin\compile\BADLY_NAME_CODE.java:15: 警告: 常量_FORTY_TWO应当全部大写字母或下划线命名，并以字母开头
 *     static final int _FORTY_TWO = 42;
 *                      ^
 * plugin\compile\BADLY_NAME_CODE.java:16: 警告: 名称NOT_A_CONSTANT应当以小写字母开头
 *     public static int NOT_A_CONSTANT = _FORTY_TWO;
 *                       ^
 * 7 个警告
 * @author kangjinshun
 * @create 2019/9/22
 * @since 1.0.0
 */
public class BADLY_NAME_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {
        return;
    }
}
