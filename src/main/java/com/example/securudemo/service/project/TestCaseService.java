package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.TestCase;

public interface TestCaseService {

	List<TestCase> getAllTestCases();
	
	TestCase findByTestCaseName(String testCaseName);

	void createTestCase(TestCase testCase);

	void deleteTestCase(Long testCaseId);
}
