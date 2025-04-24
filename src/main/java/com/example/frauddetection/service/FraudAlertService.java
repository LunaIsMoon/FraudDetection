package com.example.frauddetection.service;

import com.example.frauddetection.domain.Transaction;

public interface FraudAlertService {
    void fraudAlert(Transaction transaction);
}
