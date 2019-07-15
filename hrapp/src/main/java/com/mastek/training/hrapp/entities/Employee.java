package com.mastek.training.hrapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //one copy for each test case
@Entity //declares the class as Entity
@Table(name="JPA_EMPLOYEE") //declaring the table name for the class
@EntityListeners({EmployeeLifecyckeListener.class})
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary", query="select e from Employee e where e.salary between :min and :max")
})
public class Employee 
	implements Serializable { //manage serialization of objects
	@Value("-1")
	private int empno;
	
	@Value("Default Employee")
	private String name;
	
	@Value("100.0")
	private double salary;
	
	// getters and setters and constructor using fields
	public Employee() {
		System.out.println("Employee Created");
	}
	
	@Id //declares the property as primary key
	@Column(name="employee_number") //declares the column name
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto-numbering the primary key
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	@Column(name="employee_name",nullable=false,length=45) //cannot exceed more than 45 parameters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() { //JPA will default configurations
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//source and generate to string
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
