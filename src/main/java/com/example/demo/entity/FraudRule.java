package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String fieldName;
    private String operator;
    private String value;
    private String severity; // LOW / MEDIUM / HIGH

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    public FraudRule() {}

    public FraudRule(String ruleName, String fieldName,
                     String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.fieldName = fieldName;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }

    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public Set<Claim> getClaims() { return claims; }
    public void setClaims(Set<Claim> claims) { this.claims = claims; }
}
