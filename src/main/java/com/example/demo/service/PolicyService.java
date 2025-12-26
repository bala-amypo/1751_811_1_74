package com.example.demo.service;

import com.example.demo.entity.Policy;
import java.util.List;

public interface PolicyService {

    Policy save(Policy policy);

    List<Policy> findAll();
}
