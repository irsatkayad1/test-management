package com.example.securudemo.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.model.project.Step;
import com.example.securudemo.model.project.TestCase;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.project.DefectRepository;
import com.example.securudemo.service.history.HistoryDefectService;

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	DefectRepository defectRepository;
	
	@Autowired
	HistoryDefectService historyDefectService;
	
	@Secured("ROLE_CREATE-DEFECT")
	@Override
	public void createDefect(Defect defect) {
		
		defectRepository.save(defect);
		historyDefectService.createDefect(defect, defect.getCreatedBy());
		
	}
	
	@Secured("ROLE_DELETE-DEFECT")
	@Override
	public void deleteDefect(Long defectId) {
		Defect df = defectRepository.findById(defectId).get();
		defectRepository.deleteById(defectId);
		historyDefectService.deleteDefect(df, df.getCreatedBy());
		
	}
	
	//defect update DefectController'ın içinde!!!!
	
	@Secured("ROLE_READ-DEFECT")
	@Override
	public Defect findByDefectName(String defectName) {
		
		return defectRepository.findByDefectName(defectName);
		
	}
	
	@Secured("ROLE_READ-DEFECT")
	@Override
	public List<Defect> getAllDefects() {
		
		return defectRepository.findAll();
		
	}

	@Secured("ROLE_READ-DEFECT")
	@Override
	public List<Defect> findByProject(Project project) {
		
		return defectRepository.findByProject(project);
	}

	@Secured("ROLE_READ-DEFECT")
	@Override
	public List<Defect> findByTestCase(TestCase testCase) {
		
		return defectRepository.findByTestCase(testCase);
	}

	@Secured("ROLE_READ-DEFECT")
	@Override
	public List<Defect> findByRequirement(Requirement requirement) {
		
		return defectRepository.findByRequirement(requirement);
	}

	@Secured("ROLE_READ-DEFECT")
	@Override
	public List<Defect> findByStep(Step step) {
		
		return defectRepository.findByStep(step);
	}

	@Secured("ROLE_READ-DEFECT")
	@Override
	public List<Defect> findByAssigneeTo(User user) {
		// TODO Auto-generated method stub
		return defectRepository.findByassigneeTo(user);
	}
	
}
