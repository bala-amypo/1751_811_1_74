package com.example.demo.service.impl;

import com.example.demo.entity.Policy;
import com.example.demo.entity.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;

import java.time.LocalDate;
import java.util.List;

public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;

    // ✅ EXACT constructor expected by tests
    public PolicyServiceImpl(PolicyRepository policyRepository,
                             UserRepository userRepository) {
        this.policyRepository = policyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Policy createPolicy(Long userId, Policy policy) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (policy.getStartDate() != null && policy.getEndDate() != null &&
                policy.getEndDate().isBefore(policy.getStartDate())) {
            throw new IllegalArgumentException("Invalid policy dates");
        }

        if (policy.getPolicyNumber() != null &&
                policyRepository.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new IllegalArgumentException("Policy number already exists");
        }

        policy.setUser(user);
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepository.findByUserId(userId);
    }
}
