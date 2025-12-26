package com.example.demo.repository;

import com.example.demo.entity.FraudCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckResultRepository
        extends JpaRepository<FraudCheckResult, Long> {
}
