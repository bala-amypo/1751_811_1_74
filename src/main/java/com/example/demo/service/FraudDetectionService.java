package com.example.demo.service;

public interface FraudDetectionService {

    String runDetection(Long claimId);

    String getFraudResult(Long claimId);
}
