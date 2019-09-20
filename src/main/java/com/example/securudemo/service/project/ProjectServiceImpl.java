package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.securudemo.model.project.Project;
import com.example.securudemo.repository.project.ProjectRepository;
import com.example.securudemo.service.history.HistoryProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	HistoryProjectService historyProjectService;
	
	@Secured("ROLE_READ-PROJECT")
	@Override
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	
	@Secured("ROLE_CREATE-PROJECT")
	@Override
	public void createProject(Project project) {
		projectRepository.save(project);		
		historyProjectService.createProject(project, project.getCreatedBy());
		
	}

	@Secured("ROLE_DELETE-PROJECT")
	@Override
	public void deleteProject(Long projectId) {
		Project deletedPro = projectRepository.findById(projectId).get();
		projectRepository.deleteById(projectId);
		historyProjectService.deleteProject(deletedPro, deletedPro.getCreatedBy());
	}


	@Override
	public Project findByProjectName(String projectName) {
		return projectRepository.findByProjectName(projectName);
	}
	
}
