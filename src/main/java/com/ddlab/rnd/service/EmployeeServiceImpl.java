package com.ddlab.rnd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Department;
import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.entity.Person;
import com.ddlab.rnd.entity.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EntityManager entityMgr;

	public List<Employee> findByCity(String cityName) {

		// Step 1: Get CriteriaBuilder
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();

		// Step 2: Create CriteriaQuery
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);

		// Step 3: Define the root (FROM clause)
		Root<Employee> emp = query.from(Employee.class);

		// Step 4: Create predicates (WHERE clause)
		Predicate cityPredicate = cb.equal(emp.get("city"), cityName);
//        Predicate titlePredicate = cb.like(book.get("title"), "%" + keyword + "%");
//        Predicate pricePredicate = cb.greaterThan(book.get("price"), minPrice);

		// Step 5: Apply predicates to the query
//		TypedQuery<Employee> typedQry = query.select(emp).where(cityPredicate);
		query.select(emp).where(cityPredicate);

		// Step 6: Execute the query
		return entityMgr.createQuery(query).getResultList();
	}

	public List<Employee> findByCityIgnoreCase(String cityName) {
		// Step 1: Get CriteriaBuilder
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		// Step 2: Create CriteriaQuery
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		// Step 3: Define the root (FROM clause)
		Root<Employee> empRoot = query.from(Employee.class);

		Predicate cityPredicate = cb.equal(cb.lower(empRoot.get("city")), cityName.toLowerCase());
		query.select(empRoot).where(cityPredicate);

		return entityMgr.createQuery(query).getResultList();
	}

	public List<Employee> getEmp1(String city, Integer minAge, Double maxSal, String status) {
		// Step 1: Get CriteriaBuilder
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		// Step 2: Create CriteriaQuery
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		// Step 3: Define the root (FROM clause)
		Root<Employee> empRoot = query.from(Employee.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (city != null) {
			Predicate cityPredicate = cb.equal(empRoot.get("city"), city);
			predicates.add(cityPredicate);
		}

		if (minAge != null) {
			Predicate minAgePredicate = cb.greaterThan(empRoot.get("age"), minAge);
			predicates.add(minAgePredicate);
		}

		if (Objects.nonNull(predicates)) {
			Predicate maxSalPredicate = cb.le(empRoot.get("salary"), maxSal);
			predicates.add(maxSalPredicate);
		}

		if (!Objects.isNull(status)) {
			Predicate statusPredicate = cb.like(empRoot.get("status"), status);
			predicates.add(statusPredicate);
		}

		query.select(empRoot).where(cb.and(predicates.toArray(new Predicate[0])));

		return entityMgr.createQuery(query).getResultList();
	}

	public List<Employee> getEmpsUsingAnd(String city, String status, int age) {
		// Where city = Rourkela and status = On Leave and age > 20
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> empRoot = query.from(Employee.class);

		Predicate cityPredicate = cb.equal(empRoot.get("city"), city);
		Predicate statusPredicate = cb.like(empRoot.get("status"), status);
		Predicate agePredicate = cb.greaterThan(empRoot.get("age"), age);

		Predicate andPredicate = cb.and(cityPredicate, statusPredicate, agePredicate);

		query.select(empRoot).where(andPredicate);

		return entityMgr.createQuery(query).getResultList();
	}

	public List<Employee> getEmpsUsingOR(double sal, String status, int age) {
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> empRoot = query.from(Employee.class);

		Predicate salPredicate = cb.greaterThan(empRoot.get("salary"), sal);
		Predicate statusPredicate = cb.like(empRoot.get("status"), status);
		Predicate agePredicate = cb.greaterThan(empRoot.get("age"), age);

		Predicate andPredicate = cb.or(salPredicate, statusPredicate, agePredicate);

		query.select(empRoot).where(andPredicate);

		return entityMgr.createQuery(query).getResultList();
	}

	public List<Employee> getEmpsInCities(List<String> cityList) {
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> empRoot = query.from(Employee.class);

		Predicate cityInpredicate = empRoot.get("city").in(cityList);
		query.select(empRoot).where(cityInpredicate);

		return entityMgr.createQuery(query).getResultList();
	}
	
	public List<Employee> getEmpsForNullCity(String city) {
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> empRoot = query.from(Employee.class);

		Predicate nullCityPredicate = empRoot.get("city").isNull();
		query.select(empRoot).where(nullCityPredicate);

		return entityMgr.createQuery(query).getResultList();
	}
	
	public List<Employee> getEmpsForNotNullCity() {
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> empRoot = query.from(Employee.class);

		Predicate notNullCityPredicate = empRoot.get("city").isNotNull();
		query.select(empRoot).where(notNullCityPredicate);

		return entityMgr.createQuery(query).getResultList();
	}
	
	// Learn how to join 3 tables
	public List<Person> findEmployeesByDepartmentAndProject() {
		CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Person> query = cb.createQuery(Person.class);
		Root<Person> personRoot = query.from(Person.class);

		// Join with Department
		Join<Person, Department> departmentJoin = personRoot.join("department");

		// Join with Project
		Join<Person, Project> projectJoin = personRoot.join("projects");
		
		// Conditions
	    Predicate departmentPredicate = cb.equal(departmentJoin.get("name"), "IT");
	    Predicate projectPredicate = cb.equal(projectJoin.get("projectName"), "Apollo");

		query.select(personRoot)
        .where(cb.and(departmentPredicate, projectPredicate));
//				.distinct(true); // Because of potential duplicates in many-to-many

		return entityMgr.createQuery(query).getResultList();
	}
}
