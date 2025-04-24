package com.example.frauddetection.service.impl;

import com.example.frauddetection.domain.Transaction;
import com.example.frauddetection.service.FraudAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    @Value("${fraud.alert.topic}")
    private String alertTopic;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 欺诈交易告警
     *
     * @param transaction
     */
    @Override
    public void fraudAlert(Transaction transaction) {
        // 调用消息队列发送告警消息,交由告警模块处理告警
        kafkaTemplate.send(alertTopic, transaction.toString());
    }
}
