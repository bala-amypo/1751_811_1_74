package com.example.demo.service;

import com.example.demo.entity.FraudCheckResult;

public interface FraudDetectionService {

    FraudCheckResult runDetection(Long claimId);

    FraudCheckResult getFraudResult(Long claimId);
}
