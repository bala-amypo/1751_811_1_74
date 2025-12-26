package com.example.demo.service;

import com.example.demo.entity.Policy;
import java.util.List;

public interface PolicyService {

    Policy createPolicy(Long userId, Policy policy);

    List<Policy> getPoliciesByUser(Long userId);

    List<Policy> getAllPolicies();
}
