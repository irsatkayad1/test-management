package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.project.Defect;
import com.example.securudemo.repository.project.DefectRepository;

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	DefectRepository defectRepository;
	
	@Override
	public void createDefect(Defect defect) {
		
		defectRepository.save(defect);
		
	}
	@Override
	public void deleteDefect(Long defectId) {
		
		defectRepository.deleteById(defectId);
		
	}
	
	@Override
	public Defect findByDefectName(String defectName) {
		
		return defectRepository.findByDefectName(defectName);
		
	}
	
	@Override
	public List<Defect> getAllDefects() {
		
		return defectRepository.findAll();
		
	}
	
}
