package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service  // ⭐ THIS IS WHAT YOU WERE MISSING
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
    public FraudCheckResult runDetection(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new IllegalArgumentException("Claim not found"));

        Set<FraudRule> rules = fraudRuleRepository.findAllRules();

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setMatchedRules(
                rules.isEmpty() ? "" : "RULE_MATCHED"
        );

        return resultRepository.save(result);
    }

    @Override
    public FraudCheckResult getFraudResult(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new IllegalArgumentException("Result not found"));
    }
}
