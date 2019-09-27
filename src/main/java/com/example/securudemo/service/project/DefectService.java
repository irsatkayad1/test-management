package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.model.role.User;

public interface DefectService {

	List<Defect> getAllDefects();
	
	void createDefect(Defect defect);
	
	void deleteDefect(Long defectId);
	
	Defect findByDefectName(String defectName);
	
	List<Defect> findByProject(Project project);
	
	List<Defect> findByTestCase(TestCase testCase);
	
	List<Defect> findByRequirement(Requirement requirement);
	
	List<Defect> findByStep(Step step);
	
	List<Defect> findByAssigneeTo(User user);
	
}
