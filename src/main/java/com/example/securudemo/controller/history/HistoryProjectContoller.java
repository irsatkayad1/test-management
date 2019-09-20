package com.example.securudemo.controller.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.history.HistoryProject;
import com.example.securudemo.repository.history.HistoryProjectRepository;
import com.example.securudemo.service.history.HistoryProjectService;

@RestController
@RequestMapping("project-history")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryProjectContoller {
	
	@Autowired
	HistoryProjectService historyProjectService;
	
	@Autowired
	HistoryProjectRepository historyProjectRepository;
	
	@GetMapping("get/{projectName}")
	public List<HistoryProject> getProjectHistories(@PathVariable String projectName) {
		
		return historyProjectService.findByProjectName(projectName);
		
	}

}
