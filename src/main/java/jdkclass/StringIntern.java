package jdkclass;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/9/13
 * @since 1.0.0
 */
public class StringIntern {
    public static void main(String[] args) {
        String s1 = "计算机"+"软件";
        //此处和下面StringBuilder一样 编译器会优化成StringBuilder形式
        String s2 = new StringBuilder("ja").append("va").toString();

        System.out.println(s1.intern() == s1);
        System.out.println(s2.intern() == s2);
        /**
         * String.intern()是一个Native方法，作用：如果常量池中包含一个等于此String对象的字符串，
         * 则返回代表这个字符串的String对象；否则将此String对象包含的字符串放到常量池，并返回此
         * String对象的引用。jdk6及之前版本 常量池位于方法区（永久代），
         * jdk1.7之前 2个都返回false.因为一个在堆上一个在永久代，完全2个地址
         * jdk1.7的intern()实现不再复制实例，只是在常量池记录首次出现的实例引用，因此s1是同一个引用。
         * 对于s2 “java”这个字符串在执行StringBuilder.toString()之前就已经出现过，不符合首次出现的原则，
         * 所以这里不是同一个引用（假如s2是一个"java1"或者其他的首次出现就返回true）
         */
    }
}
