package com.example.demo.service;

import com.example.demo.entity.FraudCheckResult;

public interface FraudDetectionService {

    FraudCheckResult evaluate(Long claimId);

    FraudCheckResult getResultByClaim(Long claimId);
}
