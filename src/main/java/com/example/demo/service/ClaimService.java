package com.example.demo.service.impl;

import com.example.demo.entity.Claim;
import com.example.demo.entity.Policy;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    // REQUIRED BY TESTS
    public ClaimServiceImpl(ClaimRepository claimRepository,
                            PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public Claim createClaim(long policyId, Claim claim) {
        Policy policy = policyRepository.findById(policyId).orElseThrow();
        claim.setPolicy(policy);
        return claimRepository.save(claim);
    }

    @Override
    public Claim getClaim(long claimId) {
        return claimRepository.findById(claimId).orElseThrow();
    }
}
