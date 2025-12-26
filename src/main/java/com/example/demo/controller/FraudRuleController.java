package com.example.demo.controller;

import com.example.demo.entity.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @PostMapping
    public ResponseEntity<FraudRule> save(@RequestBody FraudRule rule) {
        return ResponseEntity.ok(
                fraudRuleService.save(rule)
        );
    }

    @GetMapping
    public ResponseEntity<List<FraudRule>> getAll() {
        return ResponseEntity.ok(
                fraudRuleService.findAll()
        );
    }
}
