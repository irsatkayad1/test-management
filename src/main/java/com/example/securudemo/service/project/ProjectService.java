package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	void createProject(Project project);

	void deleteProject(Long projectId);

	Project findByProjectName(String projectName);
	
	

}
