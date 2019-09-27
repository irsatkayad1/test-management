package com.example.securudemo.repository.history;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.history.HistoryProject;

@Repository
public interface HistoryProjectRepository extends JpaRepository<HistoryProject, Long>{
	
	List<HistoryProject> findByProjectName(String projectName);

}
