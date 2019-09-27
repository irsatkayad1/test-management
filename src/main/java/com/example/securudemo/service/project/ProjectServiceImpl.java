package com.example.securudemo.service.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.CurrentUser;
import com.example.securudemo.model.UserProjectViewModel;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.UserProject;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.project.ProjectRepository;
import com.example.securudemo.repository.project.UserProjectRepository;
import com.example.securudemo.repository.role.UserRepository;
import com.example.securudemo.service.history.HistoryProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	HistoryProjectService historyProjectService;
	
	@Autowired
	UserProjectService userProjectService;
	
	@Autowired
	UserProjectRepository userProjectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Secured("ROLE_READ-PROJECT")
	@Override
	public List<Project> getAllProjectsByUser(User user){
		
		List<UserProject> upList = userProjectRepository.findByUser(user);
		List<Project> proList = new ArrayList<>();
		try {
			for (UserProject userProject : upList) {
				proList.add(userProject.getProject());
			}
			return proList;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return proList;
		
	}
	
	
	@Secured("ROLE_CREATE-PROJECT")
	@Override
	public void createProject(UserProjectViewModel userProjectViewModel) {
		User creator = userRepository.findByUserName(CurrentUser.userName());
		Project newProject = userProjectViewModel.getProject();
		newProject.setCreatedBy(creator);
		projectRepository.save(newProject);		
		
		for (String string : userProjectViewModel.getUserName()) {
			UserProject up = new UserProject(userRepository.findByUserName(string), newProject);
			userProjectService.createUserProject(up);
			
		}		
		historyProjectService.createProject(newProject, newProject.getCreatedBy());
		
	}

	@Secured("ROLE_DELETE-PROJECT")
	@Override
	public void deleteProject(Long projectId) {
		Project deletedPro = projectRepository.findById(projectId).get();
		projectRepository.deleteById(projectId);
		historyProjectService.deleteProject(deletedPro, deletedPro.getCreatedBy());
	}


	@Secured("ROLE_READ-PROJECT")
	@Override
	public Project findByProjectName(String projectName) {
		return projectRepository.findByProjectName(projectName);
	}


	@Override
	public List<Project> findByUser(User user) {
		
		List<Project> proList = new ArrayList<>();
		try {
			userProjectService.findByUser(user).forEach(z->{
				proList.add(z.getProject());
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		return proList; 
	}
	
}
