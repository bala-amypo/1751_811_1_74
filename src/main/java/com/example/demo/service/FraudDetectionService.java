package com.example.demo.service;

import com.example.demo.entity.FraudCheckResult;

public interface FraudDetectionService {

    FraudCheckResult getFraudResult(Long claimId);
}
