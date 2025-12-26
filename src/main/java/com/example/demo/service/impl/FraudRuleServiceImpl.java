package com.example.demo.service.impl;

import com.example.demo.entity.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {

        // ✅ Severity validation (THIS FIXES THE FAILED TEST)
        if (!isValidSeverity(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity level");
        }

        // Check duplicate rule name
        Optional<FraudRule> existing =
                fraudRuleRepository.findByRuleName(rule.getRuleName());

        if (existing.isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }

        return fraudRuleRepository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }

    private boolean isValidSeverity(String severity) {
        return Set.of("LOW", "MEDIUM", "HIGH").contains(severity);
    }
}
