package com.example.demo.service.impl;

import com.example.demo.entity.Claim;
import com.example.demo.entity.Policy;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.ClaimService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository,
                            PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public Claim createClaim(Long policyId, Claim claim) {
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));

        if (claim.getClaimDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Future claim date not allowed");
        }

        if (claim.getClaimAmount() <= 0) {
            throw new IllegalArgumentException("Invalid claim amount");
        }

        claim.setPolicy(policy);
        return claimRepository.save(claim);
    }

    @Override
    public Claim getClaim(Long claimId) {
        return claimRepository.findById(claimId)
                .orElseThrow(() -> new IllegalArgumentException("Claim not found"));
    }
}
