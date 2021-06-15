package com.xiaolong.myblog.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 重试切面注解
 *
 * @author dcl
 * @since 3:20 下午 2021/6/8
 */
@Aspect
@Component
public class RetryProcessAspect {
    /**
     * 使用原子类保证数据安全
     */
    private final AtomicInteger atomicInteger = new AtomicInteger();
    /**
     *  AfterThrowing指定该切入点对应的切入表达式
     *  throwing:该属性指定一个形参名，用于表示Advice方法中可定义与此同名的形参，
     *  该形参可用于访问目标方法抛出的异常。
     */
    @AfterThrowing(pointcut = ("@annotation(com.xiaolong.myblog.common.PreventSubmit)"))
     public void tryAgain(JoinPoint point) {
        try {
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            PreventSubmit retryProcess = methodSignature.getMethod().getAnnotation(PreventSubmit.class);
            if (atomicInteger.intValue() < retryProcess.value()) {
                int i = atomicInteger.incrementAndGet();
                System.out.println("打印i"+i);
                Thread.sleep(retryProcess.sleep() * i);
                System.out.println("开始重试第" + i + "次");
                MethodInvocationProceedingJoinPoint methodPoint = ((MethodInvocationProceedingJoinPoint) point);
                methodPoint.proceed();
            }
        } catch (Throwable ex) {
            tryAgain(point);
        }
    }

}
