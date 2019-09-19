package com.example.securudemo.repository.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.history.HistoryProject;
import com.example.securudemo.model.project.Project;

@Repository
public interface HistoryProjectRepository extends JpaRepository<HistoryProject, Long>{
	
	HistoryProject findByProject(Project project);

}
