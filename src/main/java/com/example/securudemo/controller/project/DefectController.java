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

import com.example.securudemo.model.project.Defect;
import com.example.securudemo.repository.project.DefectRepository;
import com.example.securudemo.service.project.DefectService;

@RestController
@RequestMapping("defect")
@CrossOrigin(origins = "http://localhost:3000")
public class DefectController {

	@Autowired
	DefectRepository defectRepository;
	
	@Autowired
	DefectService defectService;
	
	@GetMapping("get_all_defects")
	public List<Defect> getAllDefects(){
		
		return defectService.getAllDefects();
		
	}
	
	@PostMapping("create")
	public void createDefect(@RequestBody Defect defect) {
		
		defectService.createDefect(defect);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteDefect(@PathVariable Long defectId) {
		
		defectService.deleteDefect(defectId);
		
	}
	
	@GetMapping("get/{defectName}")
	public Defect getDefectByDefectName(@PathVariable String defectName) {
		
		return defectService.findByDefectName(defectName);
		
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
			return defectRepository.save(defect);
		}).orElseGet(() ->{
			newDefect.setId(id);
			return defectRepository.save(newDefect);
		});
		
	}
	
}
