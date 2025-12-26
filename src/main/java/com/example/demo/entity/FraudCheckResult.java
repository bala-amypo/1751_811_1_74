package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;

    @Column(length = 500)
    private String matchedRules;

    private String riskLevel;

    public FraudCheckResult() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }

    public String getMatchedRules() { return matchedRules; }
    public void setMatchedRules(String matchedRules) {
        this.matchedRules = matchedRules;
    }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
