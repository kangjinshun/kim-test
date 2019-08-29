package proxy.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * 增强方法<br>
 *
 * @author kangjinshun
 * @create 2019/8/29
 * @since 1.0.0
 */
public class JavaassistTest2 {
    public static void main(String[] args) {
        modifyMehod();
    }

    private static void modifyMehod() {
        ClassPool classPool = ClassPool.getDefault();
        try {
            CtClass ctClass = classPool.get("proxy.javassist.Hello");
            CtMethod sayHello = ctClass.getDeclaredMethod("sayHello");
            sayHello.insertBefore("System.out.println(\"before\"+$1);");
            sayHello.insertAfter("System.out.println(\"after\"+$1);");
            Class aClass = ctClass.toClass();
            Hello hello = (Hello) aClass.newInstance();
            hello.sayHello("test");
            /** 结果如下
             * beforetest
             * hellotest
             * aftertest
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Hello {
    public void sayHello(String name) {
        System.out.println("hello" + name);
    }
}