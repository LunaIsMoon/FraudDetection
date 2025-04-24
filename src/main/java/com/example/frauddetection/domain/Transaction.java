package com.example.frauddetection.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
    private BigDecimal amount;
    private String accountId;
}
