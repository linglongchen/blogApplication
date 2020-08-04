package com.modules.common.config;

import com.modules.common.config.CommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Aspect
@Component
public class LogAspect {
//    @Autowired
//    private MongoTemplate mongoTemplate;

//
//    @Pointcut("execution(* com.modules.system.api..*.*(..))")
//    public void logPointCut(){}//定义一个切入点
//
//
//
//
//
//    @Around(value = "logPointCut()")
//    public void afterLog(JoinPoint joinpoint, Object rtv) {
//        System.out.println("进去切点=================");
//        LogBean logBean = new LogBean();
//        logBean.setCreateDate(new Date());
//        //获取类名
//        String classname = joinpoint.getTarget().getClass().getSimpleName();
//        logBean.setClassName(classname);
//        //获取方法名
//        String method = joinpoint.getSignature().getName();
//        logBean.setMethod(method);
//        //获取请求参数
//        String reqparam = "";
//        logBean.setReqParam(reqparam);
//        //返回值
//        if (rtv != null) {
//            logBean.setReqParam(rtv.toString());
//        }
//        //获取request对象
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        //获取ip地址是封装好的一个类
//        String ip = CommonUtils.getIp(request);
//        logBean.setIp(ip);
//        //保存mongodb
//        mongoTemplate.save(logBean);
//    }
}
