package com.example.demo.service.impl;

import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Override
    public String runDetection(Long claimId) {
        return "Fraud check completed for claim " + claimId;
    }

    @Override
    public String getFraudResult(Long claimId) {
        return "NO_FRAUD";
    }
}
