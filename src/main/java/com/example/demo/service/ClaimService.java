package com.example.demo.service;

import com.example.demo.entity.Claim;

public interface ClaimService {

    Claim createClaim(Long policyId, Claim claim);

    Claim getClaim(Long claimId);
}
