package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import org.springframework.beans.factory.annotation.Value;


@Component
@Scope("prototype")
@Entity
@Table(name="JPA_DEPARTMENT")
@NamedQueries({
	@NamedQuery(name="Department.findbyLocation", query="select e from Department e where e.location = :name")
})


public class Department implements Serializable {
	
	//@Value("-1")
	private int deptno;
	
	//@Value("Default Department")
	private String departmentname;
	
	//@Value("Leeds")
	private String location;
	
	//OneToMany: One Department has many Employees
	private Set<Employee> members= new HashSet<>();
	
	//@OneToMany: used on the get method of set to configure association 
	//fetch=LAZY: delay the initialization until method getMembers() is called
	// 		EAGER: Initialize the collection on entity find post load event
	//Cascade= All the entity operation done on department would be performed 
	//				on each associated employee object
	//			ALL: [Persist, Merge, Delete, Refresh]
	// mappedby: Identifies the propertyname in child class where the JoinColumn configuration is present 
	//			JoinColumn:ForeignKey
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="currentDepartment")
	public Set<Employee> getMembers() {
		return members;
	}
	public void setMembers(Set<Employee> members) {
		this.members = members;
	}
	
	
	@Id
	@Column(name="department_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getdepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Department() {
		System.out.println("Department Created");
	}
	
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", departmentname=" + departmentname + ", location=" + location + "]";
	}
	
	
	



	
	
	
	
	
	
	
	
	
	
	
}
