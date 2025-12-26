package com.example.demo.service;

import com.example.demo.entity.Claim;
import java.util.List;

public interface ClaimService {

    Claim createClaim(Claim claim);

    List<Claim> getAllClaims();

    Claim getClaimById(Long id);
}
