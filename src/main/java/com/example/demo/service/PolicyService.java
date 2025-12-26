package com.example.demo.service;

import com.example.demo.entity.Policy;
import java.util.List;

public interface PolicyService {

    Policy savePolicy(Policy policy);

    List<Policy> getAllPolicies();
}
