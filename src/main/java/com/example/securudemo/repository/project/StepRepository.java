package com.example.securudemo.repository.project;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;

@Repository
public interface StepRepository extends JpaRepository<Step, Long>{

	Step findByStepName(String stepName);
	List<Step> findBytestCase(TestCase testCase);
	
}