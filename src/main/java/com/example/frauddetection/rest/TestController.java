package com.example.frauddetection.rest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void test(int num) {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < num; i++) {
            jsonObject.clear();
            jsonObject.put("amount", 123);
            jsonObject.put("accountId", "account-" + (new Random()).nextInt(10));
            kafkaTemplate.send("transaction-topic", jsonObject.toJSONString());
        }
    }
}
