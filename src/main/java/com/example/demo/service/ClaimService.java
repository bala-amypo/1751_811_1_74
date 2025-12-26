package com.example.demo.service;

import com.example.demo.entity.Claim;

import java.util.List;

public interface ClaimService {

    // used by tests
    Claim createClaim(Long policyId, Claim claim);

    Claim getClaim(Long claimId);

    // used by controller
    Claim saveClaim(Claim claim);

    List<Claim> getAllClaims();
}
