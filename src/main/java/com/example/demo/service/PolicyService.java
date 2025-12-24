package com.example.demo.service;

import com.example.demo.entity.Policy;

import java.util.List;

public interface PolicyService {

    Policy savePolicy(Policy policy);

    Policy getPolicyById(Long id);

    List<Policy> getAllPolicies();
}
