package com.example.demo.service;

import com.example.demo.entity.Claim;
import java.util.List;

public interface ClaimService {

    Claim saveClaim(Claim claim);

    List<Claim> getAllClaims();
}
