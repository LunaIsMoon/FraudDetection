package com.example.frauddetection.service.impl;

import com.example.frauddetection.config.FraudRules;
import com.example.frauddetection.domain.Transaction;
import com.example.frauddetection.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 实际的欺诈规则会比较复杂，比如金额，特定帐号，交易频率等等，在这里进行处理
 */
@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Autowired
    FraudRules fraudRules;

    /**
     * 检查交易是否存在欺诈
     * @param transaction
     * @return
     */
    @Override
    public boolean existFraudulent(Transaction transaction) {

        if (fraudRules.getAmountLimit() != null && transaction.getAmount().compareTo(fraudRules.getAmountLimit()) >= 0) {
            return true;
        }
        if (!CollectionUtils.isEmpty(fraudRules.getAccountIdList()) && fraudRules.getAccountIdList().contains(transaction.getAccountId())) {
            return true;
        }
        return false;
    }
}
