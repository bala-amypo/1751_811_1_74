package com.example.demo.controller;

import com.example.demo.entity.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    // ✅ CREATE POLICY
    @PostMapping("/user/{userId}")
    public ResponseEntity<Policy> createPolicy(
            @PathVariable Long userId,
            @RequestBody Policy policy) {

        Policy saved = policyService.createPolicy(userId, policy);
        return ResponseEntity.ok(saved);
    }

    // ✅ GET ALL POLICIES
    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }
}
