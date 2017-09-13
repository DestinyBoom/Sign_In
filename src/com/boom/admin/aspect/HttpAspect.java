package com.boom.admin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用aop技术对用户请求的方法及响应的数据进行监测，
 * 以方便对错误进行处理。
 * Created by zb on 2017/9/13.
 */

//aop配置注解
@Aspect
//把类加载到spring容器
@Component
public class HttpAspect {

    //获得日志类对象
    private final static Logger looger = LoggerFactory.getLogger(HttpAspect.class);

    //切入点指示符
    @Pointcut("execution(public * com.boom.admin.controller.*.*(..))")

    public void log(){
    }

    //方法运行前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获得request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        looger.info("url={}", request.getRequestURI());
        //请求方式
        looger.info("request_method={}", request.getMethod());
        //ip
        looger.info("ip={}", request.getRemoteAddr());
        //类方法
        looger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() +"."+joinPoint.getSignature().getName());
        //参数
        looger.info("args={}", joinPoint.getArgs());
    }

    //方法运行后执行
    @After("log()")
    public void doAfter(){
        looger.info("方法已执行完!");
    }

    //获取方法返回值的注解
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        //looger.info("response={}", object.toString());
        //判断是否有返回数据
        if(object != null) {
            looger.info("response={}", object.toString());
        }else{
            looger.info("response={}", "无数据返回");
        }
    }
}

