package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    @ManyToOne
    private User user;

    public Policy() {}

    public Policy(String policyName) {
        this.policyName = policyName;
    }

    public Long getId() { return id; }
    public String getPolicyName() { return policyName; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setPolicyName(String policyName) { this.policyName = policyName; }
    public void setUser(User user) { this.user = user; }
}
