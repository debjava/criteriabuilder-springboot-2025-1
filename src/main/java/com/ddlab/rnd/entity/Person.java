package com.ddlab.rnd.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	private Department department;

	@ManyToMany
	@JoinTable(name = "person_project", // Explicitly defines the join table name
			joinColumns = @JoinColumn(name = "person_id"), // Column in the join table referencing Person's ID
			inverseJoinColumns = @JoinColumn(name = "project_id") // Column in the join table referencing Project's ID
	)
	private Set<Project> projects;

}
