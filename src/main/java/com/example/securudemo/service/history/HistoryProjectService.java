package com.example.securudemo.service.history;

import java.util.List;

import com.example.securudemo.model.history.HistoryProject;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.role.User;

public interface HistoryProjectService {
	
	void updateProject(Project project, User user);

	void createProject(Project project, User user);

	void deleteProject(Project project, User user);

	List<HistoryProject> findByProjectName(String projectName);

}
