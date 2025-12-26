package com.example.demo.controller;

import com.example.demo.entity.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}")
    public Claim createClaim(
            @PathVariable Long policyId,
            @RequestBody Claim claim) {

        return claimService.createClaim(policyId, claim);
    }

    @GetMapping("/{claimId}")
    public Claim getClaim(@PathVariable Long claimId) {
        return claimService.getClaim(claimId);
    }
}
