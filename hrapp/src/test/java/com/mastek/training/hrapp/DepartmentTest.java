package com.mastek.training.hrapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.entities.Department;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {

	@Autowired
	DepartmentService depService;
	
	@Autowired
	Department dep;
	
	@Test
	public void addDepartmentUsingService() {
		dep.setDeptno(0);
		dep.setDepartmentname("New Department");
		dep.setLocation("Leeds");
		dep=depService.registerOrUpdateDepartment(dep);
		assertNotNull(dep);
	}
	
//	@Test
//	public void findByDepnoUsingService() {
//		int depno=1;
//		assertNotNull(depService.findByDepno(depno));
//	}

}


