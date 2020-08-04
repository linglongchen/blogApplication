package com.modules.system.controller;

import com.modules.common.annotation.IgnoreSecurity;
import com.modules.common.base.BaseController;
import com.modules.common.kafka.KafkaProducer;
import com.modules.system.entity.User;
import com.modules.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author llchen
 */
@Controller
@RequestMapping("/kafka")
@Api(value = "KafkaController", tags = {"KafkaController"}, description = "kafka测试类")
public class KafkaController extends BaseController {


    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private UserService userService;


    @GetMapping("/send")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @IgnoreSecurity
    public void sendMsg(){
        User user = new User();
        userService.getByOpenId(user);
        kafkaProducer.send("this is a kafka topic message");
    }

}
