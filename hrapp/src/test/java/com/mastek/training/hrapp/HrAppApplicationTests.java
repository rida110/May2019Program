package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;

// Initialize the JUnit Test with Spring Boot Application Environment
// Spring Boot Test: used to test Spring ApplicationContext
// With all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrAppApplicationTests {
	
	//scan in memory all the components and provide the
	//best match object in the component
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService depService;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	Employee emp;
	
	
	@Test
	public void addEmployeeUsingService() {
//		Employee emp= new Employee();
//		emp.setEmpno(122);
//		emp.setName("Example");
//		emp.setSalary(333);
//		empService.registerEmployee(emp);
		
		emp.setEmpno(0);
		emp.setName("New Employee");
		emp.setSalary(9943);
		emp = empService.registerOrUpdateEmployee(emp);
		assertNotNull(emp);
	}

	@Test
	public void findByEmpnoUsingService() {
		int empno=1;
		assertNotNull(empService.findByEmpno(empno));
		
	}
//	
//	@Test
//	public void deleteByEmpnoUsingService() {
//		int empno=6;
//		empService.deleteByEmpno(empno);
//		assertNull(empService.findByEmpno(empno));
//	}
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps=empService.fetchEmployeesBySalaryRange(0, 6000);
		for(Employee employee : emps) {
			System.out.println(employee);
		}
		assertEquals(emps.size(),4);
	}
	

	@Test
	public void manageAssociations() {
		Department d1 = new Department();
		d1.setDepartmentname("Admin");
		d1.setLocation("UK");
		
		Employee emp1 = new Employee();
		emp1.setName("Admin Emp 1");
		emp1.setSalary(9433);
		
		Employee emp2 = new Employee();
		emp2.setName("Admin Emp 2");
		emp2.setSalary(34456);
		
		Project p1 = new Project();
		p1.setName("UK Project");
		p1.setCustomerName("UK Customer");
		
		Project p2 = new Project();
		p2.setName("US Project");
		p2.setCustomerName("US Customer");
	
		//One to Many: one department has many employees
		d1.getMembers().add(emp1);
		d1.getMembers().add(emp2);
		
		//many to one for each employee to assign the department
		emp1.setCurrentDepartment(d1);
		emp2.setCurrentDepartment(d1);
		
		//many to many
		emp1.getAssignments().add(p2);
		emp1.getAssignments().add(p1);
		emp2.getAssignments().add(p1);
		
		depService.registerOrUpdateDepartment(d1);
	}
	
	
	@Test
	public void contextLoads() {
		System.out.println("System Test Executed");
	
	}
	
//	@Test
//	public void simpleTest() {
//		System.out.println("System Test Executed");
//	}

}
