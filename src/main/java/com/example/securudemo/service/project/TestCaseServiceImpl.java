package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import org.springframework.stereotype.Service;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.repository.project.TestCaseRepository;

@Service
public class TestCaseServiceImpl implements TestCaseService {

	@Autowired
	TestCaseRepository testCaseRepository;
	

	@Secured("ROLE_CREATE-TESTCASE")
	@Override
	public void createTestCase(TestCase testCase) {
		
		testCaseRepository.save(testCase);
		
	}
	

	@Secured("ROLE_DELETE-TESTCASE")
	@Override
	public void deleteTestCase(Long testCaseId) {
		
		testCaseRepository.deleteById(testCaseId);
		
	}

	@Secured("ROLE_READ-TESTCASE")
	@Override
	public TestCase findByTestCaseName(String testCaseName) {
		
		return testCaseRepository.findByTestCaseName(testCaseName);
	
	}
	
	@Override
	public List<TestCase> getAllTestCases() {
		
		return testCaseRepository.findAll();
		
	}
	
}
