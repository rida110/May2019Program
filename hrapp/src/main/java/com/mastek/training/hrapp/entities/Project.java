package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_Project")
//@NamedQueries({
////	@NamedQuery(name="Project.findByCustomer",query="select e from Project e where e.customer = :name")
////})
public class Project implements Serializable{
	
	private int projectID;
	private String name;
	private String customerName;

	private Set<Employee> team= new HashSet<>();

	//mappedBy: check the configuration for Many to Many association
	//In employee class getAssignments() method
	@ManyToMany(mappedBy="assignments")
	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}
		
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	
	
	
	
	
}
