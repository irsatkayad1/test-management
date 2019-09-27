package com.example.securudemo.repository.project;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long>{

	Requirement findByRequirementName(String requirementName);
	List<Requirement> findByProject(Project project);
}