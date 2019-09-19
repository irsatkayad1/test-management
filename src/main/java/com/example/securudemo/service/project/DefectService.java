package com.example.securudemo.service.project;

import java.util.List;

import com.example.securudemo.model.project.Defect;

public interface DefectService {

	List<Defect> getAllDefects();
	
	void createDefect(Defect defect);
	
	void deleteDefect(Long defectId);
	
	Defect findByDefectName(String defectName);
	
}
