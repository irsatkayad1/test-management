package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.UserProjectViewModel;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.role.User;

public interface ProjectService {

	List<Project> getAllProjectsByUser(User user);

	void createProject(UserProjectViewModel userProjectViewModel);

	void deleteProject(Long projectId);
	
	List<Project> findByUser(User user);

	Project findByProjectName(String projectName);
	
	

}
