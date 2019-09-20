package com.example.securudemo.controller.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.project.Project;

import com.example.securudemo.repository.project.ProjectRepository;
import com.example.securudemo.service.project.ProjectService;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	

	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping("get_all_projects")
	public List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@PostMapping("create")
	public void addProject(@RequestBody Project project) {
		projectService.createProject(project);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void delPro(@PathVariable Long id) {
		projectService.deleteProject(id);
	}
	

	@GetMapping("get/{projectName}")
	public Project getProjectByProjectName(@PathVariable String projectName) {
		
		return projectService.findByProjectName(projectName);
		
	}
	@PutMapping("update/{id}")
	public Project updateProject(@RequestBody Project newProject, @PathVariable Long id) {
		
		return projectRepository.findById(id).map(project ->{
			project.setProjectName(newProject.getProjectName());
			project.setDescription(newProject.getDescription());
			project.setStatus(newProject.getStatus());
			return projectRepository.save(project);
		}).orElseGet(()->{
			newProject.setId(id);
			return projectRepository.save(newProject);
		});
		
	}

}
