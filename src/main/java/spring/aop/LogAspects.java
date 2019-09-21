package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/8/30
 * @since 1.0.0
 */

@Aspect
public class LogAspects {
    /*
     *定义一个方法,用于声明切点表达式,该方法一般没有方法体
     *@Pointcut用来声明切点表达式
     *通知直接使用定义的方法名即可引入当前的切点表达式
     */
    @Pointcut("execution(* spring.aop.MathCal.*(..))")
//    @Pointcut("execution(public int spring.aop.MathCal.div(int ,int))")
    public void point() {

    }

    //前置通知,方法执行之前执行
    @Before(value = "point()")
    public void logBefore(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("before...方法名：" + name + ",参数列表：" + Arrays.asList(joinPoint.getArgs()));
    }

    //后置通知,方法执行之后执行(不管是否发生异常)
    @After("point()")
    public void logAfter() {
        System.out.println("after...");
    }

    //返回通知,方法正常执行完毕之后执行
    @AfterReturning(value = "point()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("afterReturning...result=" + result);
    }

    //异常通知,在方法抛出异常之后执行
    @AfterThrowing(value = "point()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterThrowing..." + e);
    }

//    @Around("point()")
//    public void around(ProceedingJoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        try {
//            System.out.println("前置通知");
//            //执行目标方法
//            Object proceed = joinPoint.proceed();
//            System.out.println("后置通知");
//        } catch (Throwable throwable) {
//            System.out.println("异常通知");
//            throwable.printStackTrace();
//        }
//    }
}
