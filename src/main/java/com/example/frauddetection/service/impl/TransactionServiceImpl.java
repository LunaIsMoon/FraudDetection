package com.example.frauddetection.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.frauddetection.domain.Transaction;
import com.example.frauddetection.service.FraudAlertService;
import com.example.frauddetection.service.FraudDetectionService;
import com.example.frauddetection.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 交易服务实现类，处理消息队列传来的交易信息
 */
@Service
@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    FraudDetectionService fraudDetectionService;
    @Autowired
    FraudAlertService fraudAlertService;

    @KafkaListener(topics = "transaction-topic", groupId = "transaction-group")
    public void receiveTransactions(String message) {
        System.out.println("Received Message in group 'my-group': " + message);
        Transaction transaction = JSON.parseObject(message, Transaction.class);
        handleTransaction(transaction);
    }

    @Override
    public void handleTransaction(Transaction transaction) {
        // 欺诈判断
        if (fraudDetectionService.existFraudulent(transaction)) {
            fraudAlertService.fraudAlert(transaction);
            return;
        }

        // XXX 处理交易

    }
}
