package com.modules.common.kafka;

import com.modules.common.kafka.model.KafkaLogModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author v_vllchen
 */
@Component
@Aspect
public class KafkaAspect {
    /**
     * 日志对象
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaProducer kafkaProducer;


    @Around("execution(public * com.modules.system.service..*(..))")
    public Object doAroundService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        KafkaLogModel kafkaLogModel = new KafkaLogModel();
        kafkaLogModel.setLogType("service");
        Object[] objs = proceedingJoinPoint.getArgs();
        kafkaLogModel.setReqContent(objs);
        Object obj = proceedingJoinPoint.proceed();
        kafkaLogModel.setResContent(obj);
        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        kafkaProducer.sendLog(kafkaLogModel);
        return obj;
    }

    @Around("execution(public * com.modules.system.controller.KafkaController.*(..))")
    public Object doAroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        KafkaLogModel kafkaLogModel = new KafkaLogModel();
        kafkaLogModel.setLogType("controller");
        Object[] objs = proceedingJoinPoint.getArgs();
        kafkaLogModel.setReqContent(objs);
        Object obj = proceedingJoinPoint.proceed();
        kafkaLogModel.setResContent(obj);
        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        kafkaProducer.sendLog(kafkaLogModel);
        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        return obj;
    }
}
