package kz.laurabissoltan.tariffplanmanagement.service;

import jakarta.persistence.criteria.Predicate;
import kz.laurabissoltan.tariffplanmanagement.entity.TariffPlan;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TariffPlanSpecifications {
    public static Specification<TariffPlan> withDynamicQuery(Double minPrice, Double maxPrice, Double minDataAllowance) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(minPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
            }

            if(maxPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
            }

            if(minDataAllowance != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataAllowance"), minDataAllowance));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
