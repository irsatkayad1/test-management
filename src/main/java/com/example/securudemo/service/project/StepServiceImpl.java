package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.repository.project.StepRepository;

@Service
public class StepServiceImpl implements StepService {

	@Autowired
	StepRepository stepRepository;
	
	@Secured("ROLE_CREATE-STEP")
	@Override
	public void createStep(Step step) {
		
		stepRepository.save(step);
		
	}
	
	@Secured("ROLE_DELETE-STEP")
	@Override
	public void deleteStep(Long stepId) {
		
		stepRepository.deleteById(stepId);
		
	}
	
	@Secured("ROLE_READ-STEP")
	@Override
	public Step findByStepName(String stepName) {
		
		return stepRepository.findByStepName(stepName);
	
	}
	
	@Secured("ROLE_READ-STEP")
	@Override
	public List<Step> getAllSteps() {
		
		return stepRepository.findAll();
	
	}

	@Secured("ROLE_READ-STEP")
	@Override
	public List<Step> findByTestCase(TestCase testCase) {
		// TODO Auto-generated method stub
		return stepRepository.findBytestCase(testCase);
	}
}
