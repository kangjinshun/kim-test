package proxy.javassist;

import javassist.*;
import javassist.bytecode.AccessFlag;

import java.lang.reflect.Constructor;

/**
 * @author kangjinshun
 * @create 2019/8/28
 * @since 1.0.0
 * http://www.javassist.org/ 官方文档
 */
public class JavassistTest3 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("com.kim..CountProxy");

        // 设置接口
        CtClass interface1 = pool.get("proxy.javassist.Count");
        ctClass.setInterfaces(new CtClass[]{interface1});

        // 设置Field CtField field =
        CtField field = CtField.make("private proxy.javassist.Count count;", ctClass);
        ctClass.addField(field);

        CtClass stationClass = pool.get("proxy.javassist.CountImpl");
        CtClass[] arrays = new CtClass[]{stationClass};
        CtConstructor ctc = CtNewConstructor.make(arrays, null, CtNewConstructor.PASS_NONE, null, null, ctClass);
        // 设置构造函数内部信息
        ctc.setBody("{this.count=$1;}");
        ctClass.addConstructor(ctc);

        // 创建收取手续 takeHandlingFee方法 CtMethod takeHandlingFee =
        CtMethod takeHandlingFee = CtMethod.make("public void queryCount() {}", ctClass);
        takeHandlingFee.setBody("{System.out.println(\"-----------proxyMeyhod Start---------\");"
                + " count.queryCount();" + " System.out.println(\"-----------proxyMeyhod End---------\");}");
        ctClass.addMethod(takeHandlingFee);

        // 获取动态生成的class
        Class proxy = ctClass.toClass();
        // 获取构造器
        Constructor constructor = proxy.getConstructor(CountImpl.class);
        // 获取动态生成的class Class c = ctClass.toClass();
        // 获取构造器 Constructor
        Count o = (Count) constructor.newInstance(new CountImpl());

        o.queryCount();
        /** 结果如下
         * -----------proxyMeyhod Start---------
         * 查看账户...
         * -----------proxyMeyhod End---------
         */
        ctClass.writeFile();
        /**
         * package com.kim.;
         *
         * import proxy.javassist.Count;
         * import proxy.javassist.CountImpl;
         *
         * public class CountProxy implements Count {
         *     private Count count;
         *
         *     public CountProxy(CountImpl var1) {
         *         this.count = var1;
         *     }
         *
         *     public void queryCount() {
         *         System.out.println("-----------proxyMeyhod Start---------");
         *         this.count.queryCount();
         *         System.out.println("-----------proxyMeyhod End---------");
         *     }
         * }
         */
    }

}
