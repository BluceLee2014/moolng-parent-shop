package com.moolng.test.aspect;

import com.github.pagehelper.PageHelper;
import com.moolng.test.entity.ao.PageAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 306548063@qq.com
 * @Desc
 * @date 2020/6/7 17:25
 */
@Aspect
@Component
public class PageHelpAspect {

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
//    @Pointcut("execution(* com.moolng..page*(..))")
//    public void BrokerAspect(){
//
//    }

    /**
     * @description  在连接点执行之前执行的通知
     */
//    @Before("BrokerAspect()")
//    @Before("execution(* com.moolng..page*(..))")
//    @Before("execution(public * *(..))")
    @Before("execution(* com.moolng..service.*.*(..))")
    public void doBeforeGame(JoinPoint point){
//        Signature signature = point.getSignature();
//        // 方法名
//        String methodName = signature.getName();
//        // 类名
//        String serviceName = signature.getDeclaringTypeName();
//
//        // 参数名数组
//        String[] parameterNames = ((MethodSignature) signature).getParameterNames();
//        Class[] parameterTypes = ((MethodSignature) signature).getParameterTypes();
//
//        int i = 0;
//        for(String param : parameterNames){
//            if("PageAo".equalsIgnoreCase(param)){
////                Class parameterType = parameterTypes[i];
////                PageAO pageAO = (PageAO) parameterType;
////                PageHelper.startPage();
//            }
//            i ++;
//        }

        Object[] args = point.getArgs();
        for (Object arg : args) {
            if(arg instanceof PageAO){
                PageAO pageAO =  (PageAO)arg;
                PageHelper.startPage(pageAO.getPageNo(), pageAO.getPageSize());
            }
            System.out.println("参数="+arg+" ");
        }
//        try {
//            Object object=point.proceed();
//            System.out.println("返回值="+object);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
        System.out.println("环绕增强：日志log");
        System.out.println("经纪人正在处理球星赛前事务！");
    }

}
