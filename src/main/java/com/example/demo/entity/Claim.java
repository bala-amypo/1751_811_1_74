package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double claimAmount;

    @ManyToOne
    private Policy policy;

    public Claim() {}

    public Claim(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Long getId() { return id; }
    public Double getClaimAmount() { return claimAmount; }
    public Policy getPolicy() { return policy; }

    public void setId(Long id) { this.id = id; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public void setPolicy(Policy policy) { this.policy = policy; }
}
