package com.example.demo.service;

import com.example.demo.entity.Claim;
import java.util.List;

public interface ClaimService {

    Claim createClaim(Long policyId, Claim claim);

    Claim getClaim(Long id);

    List<Claim> getAllClaims();
}
