package com.ddlab.rnd.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Employee;

@Repository
public interface EmpRepository extends CrudRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

}
