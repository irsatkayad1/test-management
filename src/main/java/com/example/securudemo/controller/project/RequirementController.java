package com.example.securudemo.controller.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.repository.project.RequirementRepository;
import com.example.securudemo.service.project.RequirementService;

@RestController
@RequestMapping("requirement")
@CrossOrigin(origins = "http://localhost:3000")
public class RequirementController {

	@Autowired
	RequirementRepository requirementRepository;
	
	@Autowired
	RequirementService requirementService;
	
	@GetMapping("get_all_requirements")
	public List<Requirement> getAllRequirements(){
		
		return requirementService.getAllRequirements();
		
	}
	
	@PostMapping("create")
	public void createRequirement(@RequestBody Requirement requirement) {
		
		requirementService.createRequirement(requirement);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void delRequirement(@PathVariable Long requirementId) {
		
		requirementService.deleteRequirement(requirementId);
		
	}
	
	@GetMapping("get/{requirementName}")
	public Requirement getRequirementByRequirementName(@PathVariable String requirementName) {
		
		return requirementService.findByRequirementName(requirementName);
		
	}
	@PutMapping("update/{id}")
	public Requirement updateRequirement(@RequestBody Requirement newRequirement, @PathVariable Long id) {
		
		return requirementRepository.findById(id).map(requirement ->{
			requirement.setRequirementName(newRequirement.getRequirementName());
			requirement.setProject(newRequirement.getProject());
			return requirementRepository.save(requirement);
		}).orElseGet(()->{
			newRequirement.setId(id);
			return requirementRepository.save(newRequirement);
		});
	
}
}
