package com.example.demo.service.impl;

import com.example.demo.entity.Claim;
import com.example.demo.entity.FraudCheckResult;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    // Constructor order MUST match test
    public FraudDetectionServiceImpl(ClaimRepository claimRepository,
                                     FraudRuleRepository fraudRuleRepository,
                                     FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public FraudCheckResult evaluate(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new RuntimeException("Claim not found"));

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);

        // Rule condition per problem statement
        if (claim.getClaimAmount() != null && claim.getClaimAmount() > 10000) {
            result.setIsFraudulent(true);
            result.setTriggeredRuleName("HIGH_AMOUNT");
            result.setRejectionReason("Invalid claim amount");
        } else {
            result.setIsFraudulent(false);
        }

        return resultRepository.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() ->
                        new RuntimeException("Result not found"));
    }
}
