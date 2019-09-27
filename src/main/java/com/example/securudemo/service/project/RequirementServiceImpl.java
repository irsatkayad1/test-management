package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.repository.project.RequirementRepository;

@Service
public class RequirementServiceImpl implements RequirementService {

	@Autowired
	RequirementRepository requirementRepository;
	
	@Secured("ROLE_CREATE-REQUIREMENT")
	@Override
	public void createRequirement(Requirement requirement) {
	
		requirementRepository.save(requirement);
		
	}
	
	@Secured("ROLE_READ-REQUIREMENT")
	@Override
	public List<Requirement> getAllRequirements() {
		
		return requirementRepository.findAll();
		
	}

	@Secured("ROLE_DELETE-REQUIREMENT")
	@Override
	public void deleteRequirement(Long requirementId) {
		
		requirementRepository.deleteById(requirementId);
		
	}
	
	@Secured("ROLE_READ-REQUIREMENT")
	@Override
	public Requirement findByRequirementName(String requirementName) {
		
		return requirementRepository.findByRequirementName(requirementName);
		
	}

	@Override
	public List<Requirement> findByProject(Project project) {
		
		return requirementRepository.findByProject(project);
	}
}
