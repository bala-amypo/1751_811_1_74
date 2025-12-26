package com.example.demo.controller;

import com.example.demo.entity.Claim;
import com.example.demo.service.ClaimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    /**
     * POST – Create a new claim
     */
    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.createClaim(claim);
        return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
    }

    /**
     * GET – Get all claims
     */
    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimService.getAllClaims();
        return ResponseEntity.ok(claims);
    }

    /**
     * GET – Get claim by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Claim claim = claimService.getClaimById(id);
        return ResponseEntity.ok(claim);
    }

    /**
     * PUT – Update an existing claim
     */
    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(
            @PathVariable Long id,
            @RequestBody Claim updatedClaim) {

        Claim claim = claimService.updateClaim(id, updatedClaim);
        return ResponseEntity.ok(claim);
    }

    /**
     * DELETE – Delete claim by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}
