package com.example.demo.controller;

import com.example.demo.service.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/evaluate/{claimId}")
    public ResponseEntity<String> evaluate(@PathVariable Long claimId) {
        return ResponseEntity.ok(
                fraudDetectionService.runDetection(claimId)
        );
    }

    @GetMapping("/result/{claimId}")
    public ResponseEntity<String> getResult(@PathVariable Long claimId) {
        return ResponseEntity.ok(
                fraudDetectionService.getFraudResult(claimId)
        );
    }
}
