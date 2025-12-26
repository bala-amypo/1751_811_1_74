package com.example.demo.service;

import com.example.demo.entity.FraudRule;
import java.util.List;

public interface FraudRuleService {

    FraudRule save(FraudRule rule);

    List<FraudRule> findAll();
}
