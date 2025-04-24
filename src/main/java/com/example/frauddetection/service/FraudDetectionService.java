package com.example.frauddetection.service;

import com.example.frauddetection.domain.Transaction;

public interface FraudDetectionService {

    boolean existFraudulent(Transaction transaction);

}
