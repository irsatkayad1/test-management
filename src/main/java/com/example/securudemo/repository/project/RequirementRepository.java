package com.example.securudemo.repository.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Requirement;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long>{

	Requirement findByRequirementName(String requirementName);
	
}