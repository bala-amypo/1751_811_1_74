package com.example.demo.service.impl;

import com.example.demo.entity.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ THIS IS REQUIRED
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {

        // Validate severity (TEST EXPECTS IllegalArgumentException)
        if (!List.of("LOW", "MEDIUM", "HIGH").contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }

        fraudRuleRepository.findByRuleName(rule.getRuleName())
                .ifPresent(r -> {
                    throw new IllegalArgumentException("Rule already exists");
                });

        return fraudRuleRepository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }
}
