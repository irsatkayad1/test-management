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

import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.repository.project.StepRepository;
import com.example.securudemo.service.project.StepService;

@RestController
@RequestMapping("step")
@CrossOrigin(origins = "http://localhost:3000")
public class StepController {

	@Autowired
	StepRepository stepRepository;
	
	@Autowired
	StepService stepService;
	
	@GetMapping("get_all_steps")
	public List<Step> getAllSteps(){
		
		return stepService.getAllSteps();
		
	}
	
	@PostMapping("create")
	public void createStep(@RequestBody Step step) {
		
		stepService.createStep(step);
		
	}
	
	@DeleteMapping("delete/{stepId}")
	public void deleteStep(@PathVariable Long stepId) {
		
		stepService.deleteStep(stepId);
		
	}
	
	@GetMapping("testcasessteps")
	public List<Step> findBytestCase(@RequestBody TestCase testCase){
		
		return stepService.findByTestCase(testCase);
		
	}
	
	@GetMapping("get/{stepName}")
	public Step getStepName(@PathVariable String stepName) {
		
		return stepService.findByStepName(stepName);		
	}
	
	@PutMapping("update/{id}")
	public Step updateStep(@RequestBody Step newStep, @PathVariable Long id) {
		
		return stepRepository.findById(id).map(step ->{
			step.setStepName(newStep.getStepName());
			step.setDescription(newStep.getDescription());
			step.setExResult(newStep.getExResult());
			step.setPreCondition(newStep.getPreCondition());
			step.setStatus(newStep.getStatus());
			step.setTestCase(newStep.getTestCase());
			return stepRepository.save(step);
		}).orElseGet(()->{
			newStep.setId(id);
			return stepRepository.save(newStep);
		});
		
	}
	
}
	