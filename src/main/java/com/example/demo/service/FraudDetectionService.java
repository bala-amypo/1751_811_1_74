package com.example.demo.service;

import com.example.demo.model.FraudCheckResult;

public interface FraudDetectionService {

    FraudCheckResult evaluate(Long claimId);

    FraudCheckResult getResultByClaim(Long claimId);
}
