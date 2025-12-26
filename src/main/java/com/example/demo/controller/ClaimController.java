package com.example.demo.controller;

import com.example.demo.entity.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/policy/{policyId}")
    public ResponseEntity<Claim> createClaim(
            @PathVariable Long policyId,
            @RequestBody Claim claim) {

        return ResponseEntity.ok(
                claimService.createClaim(policyId, claim)
        );
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getClaims() {
        return ResponseEntity.ok(
                claimService.findAll()
        );
    }

    @PutMapping("/{claimId}")
    public ResponseEntity<Claim> updateClaim(
            @PathVariable Long claimId,
            @RequestBody Claim claim) {

        return ResponseEntity.ok(
                claimService.updateClaim(claimId, claim)
        );
    }

    @DeleteMapping("/{claimId}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long claimId) {
        claimService.delete(claimId);
        return ResponseEntity.noContent().build();
    }
}
