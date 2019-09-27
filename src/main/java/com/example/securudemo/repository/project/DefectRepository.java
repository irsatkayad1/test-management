package com.example.securudemo.repository.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.model.role.User;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long>  {

	Defect findByDefectName(String defectName);
	
	List<Defect> findByProject(Project project);
	
	List<Defect> findByTestCase(TestCase testCase);
	
	List<Defect> findByRequirement(Requirement requirement);
	
	List<Defect> findByStep(Step step);
	
	List<Defect> findByassigneeTo(User user);
	
}
