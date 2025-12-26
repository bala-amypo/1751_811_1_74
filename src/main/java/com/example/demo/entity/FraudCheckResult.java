package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;

    @Column(length = 1000)
    private String matchedRules;

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getMatchedRules() {
        return matchedRules;
    }

    public void setMatchedRules(String matchedRules) {
        this.matchedRules = matchedRules;
    }
}
