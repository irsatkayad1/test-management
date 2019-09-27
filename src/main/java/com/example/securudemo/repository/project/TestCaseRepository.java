package com.example.securudemo.repository.project;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.model.project.TestCase;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long>{

	TestCase findByTestCaseName(String testCaseName);
	List<TestCase> findByRequirement(Requirement requirement);
	
}