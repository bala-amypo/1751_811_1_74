package com.example.demo.service.impl;

import com.example.demo.entity.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public class FraudRuleServiceImpl implements FraudRuleService {

    private static final Set<String> VALID_SEVERITIES =
            Set.of("LOW", "MEDIUM", "HIGH");

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (!VALID_SEVERITIES.contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }

        fraudRuleRepository.findByRuleName(rule.getRuleName())
                .ifPresent(r -> {
                    throw new IllegalArgumentException("Rule already exists");
                });

        return fraudRuleRepository.save(rule);
    }
}
