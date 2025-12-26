package com.example.demo.service.impl;

import com.example.demo.entity.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Override
    public Policy save(Policy policy) {
        return policy;
    }

    @Override
    public List<Policy> findAll() {
        return new ArrayList<>();
    }
}
