package com.ddlab.rnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.entity.Person;
import com.ddlab.rnd.repository.EmpRepository;
import com.ddlab.rnd.repository.EmpSpecifications;
import com.ddlab.rnd.repository.EmployeeRepository;
import com.ddlab.rnd.service.EmployeeServiceImpl;

@Component
public class AutoRun {

	@Autowired
	private EmployeeServiceImpl empServImpl;

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private EmpRepository empRepository;

	public void useOfORInQuery() {
		// Get the list of emps where sal > 50K or status = On leave or age > 30
	}

	public void useOfAndInQuery() {
//		List<Employee> emps = empServImpl.getEmpsUsingAnd("Rourkela", "On Leave", 20);
//		emps.forEach( emp -> System.out.println("Emp: "+emp));

		// Equivalent using @Query Annotation
		List<Employee> emps = empRepo.getEmpsUsingAnd("Rourkela", "On Leave", 20);
		emps.forEach(emp -> System.out.println("Emp: " + emp));
	}

	public void useOfOrInQuery() {
//		List<Employee> emps = empServImpl.getEmpsUsingOR(50000, "On Leave", 30);
//		emps.forEach( emp -> System.out.println("Emp: "+emp));
//		System.out.println("Total Count : "+emps.size());

		// Equivalent using @Query Annotation
		List<Employee> emps = empRepo.getEmpsUsingOR(50000, "On Leave", 30);
		emps.forEach(emp -> System.out.println("Emp: " + emp));
		System.out.println("Total Count : " + emps.size());
	}

	public void useOfIN() {
//		List<Employee> emps = empServImpl.getEmpsInCities(List.of("Rourkela","Bhubaneswar"));
//		emps.forEach( emp -> System.out.println("Emp: "+emp));
//		System.out.println("Total Count : "+emps.size());

		// Equivalent using @Query Annotation
		List<Employee> emps = empRepo.getEmpsInCities(List.of("Rourkela", "Bhubaneswar"));
		emps.forEach(emp -> System.out.println("Emp: " + emp));
		System.out.println("Total Count : " + emps.size());
	}

	public void useOfNull() {
//		List<Employee> emps = empServImpl.getEmpsForNullCity(null);
//		emps.forEach( emp -> System.out.println("Emp: "+emp));
//		System.out.println("Total Count : "+emps.size());

		// Equivalent using @Query Annotation
		List<Employee> emps = empRepo.getEmpsForNullCity(null);
		emps.forEach(emp -> System.out.println("Emp: " + emp));
		System.out.println("Total Count : " + emps.size());
	}
	
	public void useOfNotNull() {
//		List<Employee> emps = empServImpl.getEmpsForNotNullCity();
//		emps.forEach( emp -> System.out.println("Emp: "+emp));
//		System.out.println("Total Count : "+emps.size());

		// Equivalent using @Query Annotation
		List<Employee> emps = empRepo.getEmpsForNotNullCity();
		emps.forEach(emp -> System.out.println("Emp: " + emp));
		System.out.println("Total Count : " + emps.size());
	}
	
	public void showEmpsBasedOnSpecification() {
//		List<Employee> emps = empRepository.findAll(EmpSpecifications.hasNameLike("Mishra"));
//		List<Employee> emps = empRepository.findAll(EmpSpecifications.hasNameLike("Mishra")
//				.and(EmpSpecifications.isWithinAgeRange(30, 40)));
//		emps.forEach(emp -> System.out.println("Emp: " + emp));
//		System.out.println("Total Count : " + emps.size());
		
		
		// Combine Specifications Dynamically, use it in Service layer
//		Specification<Employee> spec = Specification // Specification.where() is deprecated
//		.where(EmpSpecifications.hasNameLike("Mishra")
//				.and(EmpSpecifications.isWithinAgeRange(30, 40))
//				.and(EmpSpecifications.hasStatus("Active")));
		
		// Combine Specifications Dynamically, use it in Service layer
		Specification<Employee> spec = EmpSpecifications.hasNameLike("Mishra")
			    .and(EmpSpecifications.isWithinAgeRange(30, 40))
//			    .and(EmpSpecifications.hasStatus("Active"));
			    .and(EmpSpecifications.hasStatus(null)); // This also works
		
		List<Employee> emps = empRepository.findAll(spec);
		emps.forEach(emp -> System.out.println("Emp: " + emp));
		System.out.println("Total Count : " + emps.size());
		
	}
	
	public void join3TablesWithCondition() {
		List<Person> persons = empServImpl.findEmployeesByDepartmentAndProject();
		System.out.println("Total Count : " + persons.size());
		persons.forEach(person -> System.out.println("Person: " + person));
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("Started running ...");
//		List<Employee> emps = empServImpl.findByCity("Bhubaneswar");
//		emps.forEach( emp -> System.out.println("Emp: "+emp));

		// In case of Case Insensitive City Name
//		List<Employee> emps = empServImpl.findByCityIgnoreCase("cuttack");
//		emps.forEach( emp -> System.out.println("Emp: "+emp));

		// Get employee with several where clause
//		List<Employee> emps = empServImpl.getEmp1("Bhubaneswar", Integer.valueOf(18), Double.valueOf(99000), "Active");
//		emps.forEach( emp -> System.out.println("Emp: "+emp));

		// The above can be achieved using @Query annotation
//		List<Employee> emps = empRepo.getEmpDetails("Bhubaneswar", Integer.valueOf(18), Double.valueOf(99000), "Active");
//		emps.forEach( emp -> System.out.println("Emp: "+emp));

//		useOfAndInQuery();

//		useOfOrInQuery();

//		useOfIN();

//		useOfNull();
		
//		useOfNotNull();
		
//		showEmpsBasedOnSpecification();
		
		join3TablesWithCondition();
		
	}

}
