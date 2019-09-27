package com.example.securudemo.repository.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.UserProject;
import com.example.securudemo.model.role.User;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Long> {

	Project findByProject(Project project);
	List<UserProject> findByUser(User user);
	
}
