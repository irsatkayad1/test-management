package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;

public interface StepService {

	List<Step> getAllSteps();
	
	Step findByStepName(String stepName);
	
	void createStep(Step step);
	
	void deleteStep(Long stepId);

	List<Step> findByTestCase(TestCase testCase);
	
}
