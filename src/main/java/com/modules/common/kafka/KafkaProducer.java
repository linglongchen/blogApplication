package com.modules.common.kafka;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author v_vllchen
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 自定义topic
     */
    public static final String TOPIC_TEST = "log";
    public static final String TOPIC_LOG = "log";
    public static final String TOPIC_GROUP1 = "topic.group1";
    public static final String TOPIC_GROUP2 = "topic.group2";

    public void send(Object msg){
        String obj = JSONObject.toJSONString(msg);
        logger.info("准备发送消息:{}",obj);
        //发送消息
        ListenableFuture future = kafkaTemplate.send(TOPIC_TEST, obj);
        future.addCallback(object -> {
            logger.info("发送成功:{}", obj);
        }, (e) -> {
            e.printStackTrace();
            logger.info("发送失败");
        });
    }

    public void sendLog(Object msg){
        String obj = JSONObject.toJSONString(msg);
        logger.info("准备发送消息:{}",obj);
        //发送消息
        ListenableFuture future = kafkaTemplate.send(TOPIC_LOG, obj);
        future.addCallback(object -> {
            logger.info("发送成功:{}", obj);
        }, (e) -> {
            e.printStackTrace();
            logger.info("发送失败");
        });
    }

}
