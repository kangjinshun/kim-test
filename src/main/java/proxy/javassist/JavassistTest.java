package proxy.javassist;

import javassist.*;
import javassist.bytecode.AccessFlag;

/**
 * 字节码生成器<br>
 *
 * @author kangjinshun
 * @create 2019/8/28
 * @since 1.0.0
 * http://www.javassist.org/ 官方文档
 */
public class JavassistTest {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        // 创建类
        CtClass ctClass = pool.makeClass("com.kim.GenerateClass");
        // 让类实现接口
        ctClass.setInterfaces(new CtClass[]{pool.makeInterface("java.lang.Cloneable")});
        ctClass.addInterface(pool.makeInterface("java.lang.Serializable"));
        try {
            // 创建一个字段 id 设置为public 类型
            CtField field = new CtField(CtClass.intType, "id", ctClass);
            ctClass.addField(field);
            field.setModifiers(AccessFlag.PUBLIC);
            // 新增构造方法
            ctClass.addConstructor(CtNewConstructor.make("public GenerateClass(int id){ this .id =id; }", ctClass));
            // 增加普通方法
            CtMethod method = CtNewMethod.make("public void sayHello(int id){System.out.println(\"你好啊\"+id);}", ctClass);
            ctClass.addMethod(method);
            // 写到磁盘
            ctClass.writeFile();
            // 反编译之后如下代码
            /**
             * package com.kim;
             *
             * import java.io.PrintStream;
             *
             * public class GenerateClass
             *   implements Cloneable, Serializable
             * {
             *   public int id;
             *
             *   public GenerateClass(int paramInt)
             *   {
             *     this.id = paramInt;
             *   }
             *
             *   public void sayHello(int paramInt)
             *   {
             *     System.out.println("你好啊" + paramInt);
             *   }
             * }
             */

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
