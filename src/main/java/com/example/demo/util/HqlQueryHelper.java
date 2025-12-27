package com.example.demo.util;

import com.example.demo.entity.Claim;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HqlQueryHelper {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * HQL query:
     * Find claims with amount greater than a given value
     */
    public List<Claim> findHighValueClaims(double minAmount) {
        String hql = "SELECT c FROM Claim c WHERE c.claimAmount > :minAmount";

        TypedQuery<Claim> query = entityManager.createQuery(hql, Claim.class);
        query.setParameter("minAmount", minAmount);

        return query.getResultList();
    }

    /**
     * Criteria API query:
     * Find claims whose description contains a keyword
     */
    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Claim> cq = cb.createQuery(Claim.class);
        Root<Claim> root = cq.from(Claim.class);

        if (keyword == null || keyword.isEmpty()) {
            cq.select(root);
        } else {
            Predicate predicate =
                    cb.like(cb.lower(root.get("description")),
                            "%" + keyword.toLowerCase() + "%");
            cq.where(predicate);
        }

        return entityManager.createQuery(cq).getResultList();
    }
}
