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

    @PostMapping("/detect/{claimId}")
    public FraudCheckResult detectFraud(@PathVariable Long claimId) {
        return fraudDetectionService.runDetection(claimId);
    }

    @GetMapping("/result/{claimId}")
    public FraudCheckResult getResult(@PathVariable Long claimId) {
        return fraudDetectionService.getFraudResult(claimId);
    }
}
