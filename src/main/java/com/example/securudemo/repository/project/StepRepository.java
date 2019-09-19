package com.example.securudemo.repository.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long>{

	Step findByStepName(String stepName);
	
}