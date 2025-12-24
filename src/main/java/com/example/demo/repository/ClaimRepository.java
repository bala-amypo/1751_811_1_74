package com.example.demo.repository;

import com.example.demo.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByPolicy_Id(Long policyId);
}
