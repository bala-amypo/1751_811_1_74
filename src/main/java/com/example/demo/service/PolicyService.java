package com.example.demo.service.impl;

import com.example.demo.entity.Policy;
import com.example.demo.entity.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;

    // REQUIRED BY TESTS
    public PolicyServiceImpl(PolicyRepository policyRepository,
                             UserRepository userRepository) {
        this.policyRepository = policyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Policy createPolicy(long userId, Policy policy) {
        User user = userRepository.findById(userId).orElseThrow();
        policy.setUser(user);
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(long userId) {
        return policyRepository.findAll()
                .stream()
                .filter(p -> p.getUser() != null && p.getUser().getId() == userId)
                .collect(Collectors.toList());
    }
}
