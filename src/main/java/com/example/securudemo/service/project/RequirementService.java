package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;

public interface RequirementService {

	List<Requirement> getAllRequirements();
	
	void createRequirement(Requirement requirement);
		
	void deleteRequirement(Long requirementId);
	
	Requirement findByRequirementName(String requirementName);

	List<Requirement> findByProject(Project project);
	
	
}
