package com.example.demo.service.impl;

import com.example.demo.entity.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    @Override
    public FraudRule save(FraudRule rule) {
        return rule;
    }

    @Override
    public List<FraudRule> findAll() {
        return new ArrayList<>();
    }
}
