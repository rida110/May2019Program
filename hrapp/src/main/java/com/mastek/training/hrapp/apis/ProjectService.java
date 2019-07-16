package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;


@Component
@Scope("singleton")
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public ProjectService() {
		System.out.println("Project Service Created");
	}
	
	public Project registerOrUpdateProject(Project pro) {
		pro = projectRepository.save(pro);
		System.out.println("Project Registered"+pro);
		return pro;
	}
	
	public Project findByProjectID(int projectID) {
		try {
			return projectRepository.findById(projectID).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//		public List<Project>findByCustomer(String name){
//			return projectRepository.findByCustomer(name);
//		}
//		
		public void deleteByProjectID(int projectID) {
			projectRepository.deleteById(projectID);
		}




}
