package com.ddlab.rnd.repository;

import org.springframework.data.jpa.domain.Specification;

import com.ddlab.rnd.entity.Employee;

public class EmpSpecifications {
	
	public static Specification<Employee> hasNameLike(String namePattern) {
        return (root, query, criteriaBuilder) 
        		-> namePattern == null ? null : criteriaBuilder.like(root.get("name"), "%" + namePattern + "%");
    }
	
	public static Specification<Employee> isWithinAgeRange(Integer minAge, Integer maxAge) {
        return (root, query, criteriaBuilder) 
        		-> criteriaBuilder.between(root.get("age"), minAge, maxAge);
    }
	
	public static Specification<Employee> hasStatus(String status) {
        return (root, query, criteriaBuilder) 
        		-> status == null ? null : criteriaBuilder.equal(root.get("status"), status);
    }

}
