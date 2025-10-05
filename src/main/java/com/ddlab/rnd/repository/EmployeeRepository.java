package com.ddlab.rnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Employee;

import jakarta.persistence.Id;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query("""
		    SELECT e FROM Employee e
		    WHERE (:city IS NULL OR e.city = :city)
		      AND (:minAge IS NULL OR e.age > :minAge)
		      AND (:maxSal IS NULL OR e.salary <= :maxSal)
		      AND (:status IS NULL OR e.status LIKE :status)
		""")
	List<Employee> getEmpDetails(String city, Integer minAge, Double maxSal, String status);
	
	@Query(""" 
			SELECT e FROM Employee e WHERE 
			e.city = :city 
			AND e.status = :status
			AND e.age > :age
			"""
			)
	List<Employee> getEmpsUsingAnd(String city, String status, int age);
	
	@Query(""" 
			SELECT e FROM Employee e WHERE 
			e.salary > :sal 
			OR e.status LIKE :status
			OR e.age > :age
			"""
			)
	List<Employee> getEmpsUsingOR(double sal, String status, int age);
	
	@Query(""" 
			SELECT e FROM Employee e WHERE e.city in :cityList
			""")
	List<Employee> getEmpsInCities(List<String> cityList);
	
	@Query("""
		    SELECT e FROM Employee e
		    WHERE (e.city IS NULL)
		""")
	List<Employee> getEmpsForNullCity(String city);
	
	
	@Query("""
		    SELECT e FROM Employee e
		    WHERE (e.city IS NOT NULL)
		""")
	List<Employee> getEmpsForNotNullCity();

	

}
