package com.example.securudemo.repository.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findByProjectName(String projectName);
	
}