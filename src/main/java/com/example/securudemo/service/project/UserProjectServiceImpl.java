package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.project.UserProject;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.project.UserProjectRepository;

@Service
public class UserProjectServiceImpl implements UserProjectService{

	@Autowired
	UserProjectRepository userProjectRepository;
	
	@Override
	public void createUserProject(UserProject userProject) {
		
		userProjectRepository.save(userProject);
		
	}
	@Override
	public void deleteUserProject(Long userProjectId) {
		
		userProjectRepository.deleteById(userProjectId);
		
	}
	@Override
	public List<UserProject> getAllUserProjects() {
		
		return userProjectRepository.findAll();
	
	}
	
	@Override
	public List<UserProject> findByUser(User user){
		
		
		return userProjectRepository.findByUser(user);
		
		
	}
	
}
