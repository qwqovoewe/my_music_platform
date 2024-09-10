package com.wrx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect  //标识这是一个切面类
@Component
public class InvokeLogAspect {

    //确定切点
    @Pointcut("@annotation(com.wrx.aop.InvokeLog)")
    public void pt(){
    }

    @Around("pt()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint){
        //目标方法调用前
        Object proceed = null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println(methodName+"即将被进行aop增强");
        try {
            proceed = joinPoint.proceed();
            //目标方法调用后
            System.out.println(methodName+"被增强完了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //目标方法出现异常了
            System.out.println(methodName+"增强出现了异常");
        }
        return proceed;
    }
}