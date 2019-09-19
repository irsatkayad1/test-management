package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.project.Step;
import com.example.securudemo.repository.project.StepRepository;

@Service
public class StepServiceImpl implements StepService {

	@Autowired
	StepRepository stepRepository;
	
	@Secured("ROLE_READPROJECT")
	@Override
	public void createStep(Step step) {
		
		stepRepository.save(step);
		
	}
	
	@Secured("ROLE_READPROJECT")
	@Override
	public void deleteStep(Long stepId) {
		
		stepRepository.deleteById(stepId);
		
	}
	
	@Secured("ROLE_READPROJECT")
	@Override
	public Step findByStepName(String stepName) {
		
		return stepRepository.findByStepName(stepName);
	
	}
	
	@Secured("ROLE_READPROJECT")
	@Override
	public List<Step> getAllSteps() {
		
		return stepRepository.findAll();
	
	}
}
