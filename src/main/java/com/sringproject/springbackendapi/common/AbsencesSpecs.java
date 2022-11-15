package com.sringproject.springbackendapi.common;

import com.sringproject.springbackendapi.model.Absences;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class AbsencesSpecs {
    public static Specification<Absences> findByCriteria(final SearchCriteria searchCriteria) {
        return new Specification<Absences>() {
            @Override
            public Predicate toPredicate(Root<Absences> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if(searchCriteria.getStatus() != null) {

                    switch (searchCriteria.getStatus()) {
                        case "Requested":
                            predicates.add(criteriaBuilder.isNull(root.get("rejectedAt")));
                            predicates.add(criteriaBuilder.isNull(root.get("confirmedAt")));
                            break;
                        case "Confirmed":
                            predicates.add(criteriaBuilder.isNotNull(root.get("confirmedAt")));
                            predicates.add(criteriaBuilder.isNull(root.get("rejectedAt")));
                            break;
                        case "Rejected":
                            predicates.add(criteriaBuilder.isNull(root.get("confirmedAt")));
                            predicates.add(criteriaBuilder.isNotNull(root.get("rejectedAt")));
                            break;
                    }
                }

                if(searchCriteria.getType() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("type"), searchCriteria.getType()));
                }

                if(searchCriteria.getEndDate() != null && searchCriteria.getStartDate() != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<Date>get("startDate"),searchCriteria.getStartDate()));
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<Date>get("endDate"), searchCriteria.getEndDate()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
            }
        };
    }

}
