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

import com.example.securudemo.model.CurrentUser;
import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.repository.project.DefectRepository;
import com.example.securudemo.service.history.HistoryDefectService;
import com.example.securudemo.service.project.DefectService;
import com.example.securudemo.service.role.UserService;

@RestController
@RequestMapping("defect")
@CrossOrigin(origins = "http://localhost:3000")
public class DefectController {

	@Autowired
	DefectRepository defectRepository;
	
	@Autowired
	DefectService defectService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HistoryDefectService historyDefectService;
	
	@GetMapping("get_all_defects")
	public List<Defect> getAllDefects(){
		
		return defectService.getAllDefects();
		
	}
	
	@PostMapping("create")
	public void createDefect(@RequestBody Defect defect) {
		
		defectService.createDefect(defect);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteDefect(@PathVariable Long id) {
		
		defectService.deleteDefect(id);
		
	}
	
	@GetMapping("get/ByAssigneeTo")
	public List<Defect> getByAssigneeTo(){
		
		return defectService.findByAssigneeTo(userService.findByUserName(CurrentUser.userName()));
		
	}
	
	@GetMapping("get/{defectName}")
	public Defect getDefectByDefectName(@PathVariable String defectName) {
		
		return defectService.findByDefectName(defectName);
		
	}
	
	@GetMapping("get/byproject")
	public List<Defect> findByProject(@RequestBody Project project){
		
		return defectService.findByProject(project);
	}
	
	@GetMapping("get/byrequirement")
	public List<Defect> findByRequirement(@RequestBody Requirement requirement){
		
		return defectService.findByRequirement(requirement);
	}
	
	@GetMapping("get/bycase")
	public List<Defect> findByTestCase(@RequestBody TestCase testCase){
		
		return defectService.findByTestCase(testCase);
	}
	
	@GetMapping("get/bystep")
	public List<Defect> findByStep(@RequestBody Step step){
		
		return defectService.findByStep(step);
	}
	
	
	//solution tarafından defect'in statusu, developerComment'i, assigneeTo'su değiştirilebilir
	@PutMapping("updateBySolution/{id}")
	public Defect updateBySolution(@RequestBody Defect newDefect, @PathVariable Long id) {
		
		return defectRepository.findById(id).map(defect -> {
			defect.setAssigneeTo(newDefect.getAssigneeTo());
			defect.setAssigneeToGroup(newDefect.getAssigneeToGroup());
			defect.setDeveloperComment(newDefect.getDeveloperComment());
			defect.setStatus(newDefect.getStatus());
			historyDefectService.updateDefect(defect, defect.getCreatedBy());
			return defectRepository.save(defect);
			
			
		}).orElseGet(() ->{
			newDefect.setId(id);
			historyDefectService.updateDefect(newDefect, newDefect.getCreatedBy());
			return defectRepository.save(newDefect);
		});
	}
	
	
	@PutMapping("update/{id}")
	public Defect updateDefect(@RequestBody Defect newDefect, @PathVariable Long id) {
		
		return defectRepository.findById(id).map(defect -> {
			defect.setDefectName(newDefect.getDefectName());
			defect.setSummary(newDefect.getSummary());
			defect.setTestCase(newDefect.getTestCase());
			defect.setStep(newDefect.getStep());
			defect.setRequirement(newDefect.getRequirement());
			defect.setProject(newDefect.getProject());
			defect.setPhaseFound(newDefect.getPhaseFound());
			defect.setAssigneeTo(newDefect.getAssigneeTo());
			defect.setAssigneeToGroup(newDefect.getAssigneeToGroup());
			defect.setCreatedBy(newDefect.getCreatedBy());
			defect.setDescription(newDefect.getDescription());
			defect.setDeveloperComment(newDefect.getDeveloperComment());
			defect.setStatus(newDefect.getStatus());
			historyDefectService.updateDefect(defect, defect.getCreatedBy());
			return defectRepository.save(defect);
			
			
		}).orElseGet(() ->{
			newDefect.setId(id);
			historyDefectService.updateDefect(newDefect, newDefect.getCreatedBy());
			return defectRepository.save(newDefect);
		});
		
	}
	
}
