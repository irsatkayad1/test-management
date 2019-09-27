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
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.repository.project.TestCaseRepository;
import com.example.securudemo.service.project.TestCaseService;

@RestController
@RequestMapping("testcase")
@CrossOrigin(origins = "http://localhost:3000")
public class TestCaseController {

	@Autowired
	TestCaseRepository testCaseRepository;
	
	@Autowired
	TestCaseService testCaseService;
	
	@GetMapping("get_all_testcases")
	public List<TestCase> getAllTestCases(){
		
		return testCaseService.getAllTestCases();
		
	}
	
	@GetMapping("requirementstestcases")
	public List<TestCase> findByRequirement(@RequestBody Requirement requirement){
		
		return testCaseService.findByRequirement(requirement);
		
	}
	
	@PostMapping("create")
	public void createTestCase(@RequestBody TestCase testCase) {
		
		testCaseService.createTestCase(testCase);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteTestCase(@PathVariable Long testCaseId) {
		
		testCaseService.deleteTestCase(testCaseId);
		
	}
	
	@GetMapping("get/{testCaseName}")
	public TestCase getTestCaseByTestCaseName(@PathVariable String testCaseName) {
		
		return testCaseService.findByTestCaseName(testCaseName);		
	}
	
	@PutMapping("update/{id}")
	public TestCase updateTestCase(@RequestBody TestCase newTestCase, @PathVariable Long id) {
		
		return testCaseRepository.findById(id).map(testCase ->{
			testCase.setTestCaseName(newTestCase.getTestCaseName());
			testCase.setDescription(newTestCase.getDescription());
			testCase.setStatus(newTestCase.getStatus());
			testCase.setRequirement(newTestCase.getRequirement());
			testCase.setType(newTestCase.getType());
			return testCaseRepository.save(testCase);
		}).orElseGet(()->{
			newTestCase.setId(id);
			return testCaseRepository.save(newTestCase);
		});
		
	}
}
