package com.example.demo.service.impl;

import com.example.demo.entity.Claim;
import com.example.demo.entity.FraudCheckResult;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudDetectionService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(
            ClaimRepository claimRepository,
            FraudRuleRepository fraudRuleRepository,
            FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void detectFraud(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new IllegalArgumentException("Claim not found"));

        FraudCheckResult result = new FraudCheckResult();
        result.setClaimId(claim.getId());
        result.setMatchedRules("");
        result.setRiskLevel("LOW");

        resultRepository.save(result);
    }
}
