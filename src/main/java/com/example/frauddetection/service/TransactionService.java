package com.example.frauddetection.service;

import com.example.frauddetection.domain.Transaction;

public interface TransactionService {

    void handleTransaction(Transaction transaction);
}
