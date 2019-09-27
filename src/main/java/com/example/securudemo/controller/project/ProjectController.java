package com.example.securudemo.controller.project;

import java.util.ArrayList;
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

import com.example.securudemo.model.CurrentUser;
import com.example.securudemo.model.UserProjectViewModel;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.UserProject;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.project.ProjectRepository;
import com.example.securudemo.repository.project.UserProjectRepository;
import com.example.securudemo.service.project.ProjectService;
import com.example.securudemo.service.project.UserProjectService;
import com.example.securudemo.service.role.UserService;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserProjectRepository userProjectRepository;
	
	@Autowired
	UserProjectService userProjectService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("userspros")
	public List<Project> findByuser(){
		User user = userService.findByUserName(CurrentUser.userName());
		List<Project> proList = new ArrayList<>();
		System.out.println(user);
		try {
			for (UserProject up : userProjectService.findByUser(user)) {
				System.out.println(up.getProject());
				proList.add(up.getProject());
			}	

			return proList;	
			
		} catch (Exception e) {
			return null;
		}
		
	}	
	
	@GetMapping("get/{projectName}")
	public Project getProjectByProjectName(@PathVariable String projectName) {
		
		return projectService.findByProjectName(projectName);
		
	}
	
	@PostMapping("create")
	public void addProject(@RequestBody  UserProjectViewModel userProjectViewModel) {
		
		projectService.createProject(userProjectViewModel);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void delPro(@PathVariable Long id) {
		System.out.println(id);
		projectService.deleteProject(id);
		
	}
	
	
	@PutMapping("update/{id}")
	public Project updateProject(@RequestBody Project newProject, @PathVariable Long id) {
		
		return projectRepository.findById(id).map(project ->{
			project.setProjectName(newProject.getProjectName());
			project.setDescription(newProject.getDescription());
			project.setStatus(newProject.getStatus());
			project.setCreateDate(null);
			project.setCreatedBy(null);
			project.setExEndDate(null);
			project.setExStartDate(null);

			return projectRepository.save(project);
		}).orElseGet(()->{
			newProject.setId(id);
			return projectRepository.save(newProject);
		});
		
	}

}
