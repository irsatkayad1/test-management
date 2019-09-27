package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.UserProject;
import com.example.securudemo.model.role.User;

public interface UserProjectService {

	List<UserProject> getAllUserProjects();
	
	void createUserProject(UserProject userProject);
	
	void deleteUserProject(Long userProjectId);

	List<UserProject> findByUser(User user);
	
}
