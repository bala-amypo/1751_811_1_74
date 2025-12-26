package com.example.demo.service;

import com.example.demo.entity.Policy;

import java.util.List;

public interface PolicyService {

    // used by tests
    Policy createPolicy(Long userId, Policy policy);

    List<Policy> getPoliciesByUser(Long userId);

    // used by controller
    Policy savePolicy(Policy policy);

    List<Policy> getAllPolicies();
}
