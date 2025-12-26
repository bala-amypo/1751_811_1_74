package com.example.demo.controller;

import com.example.demo.entity.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/{claimId}")
    public FraudCheckResult detect(@PathVariable Long claimId) {
        return fraudDetectionService.runDetection(claimId);
    }

    @GetMapping("/{claimId}")
    public FraudCheckResult get(@PathVariable Long claimId) {
        return fraudDetectionService.getFraudResult(claimId);
    }
}
