package com.example.securudemo.service.history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.history.HistoryDefect;
import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.history.HistoryDefectRepository;

@Service
public class HistoryDefectServiceImpl implements HistoryDefectService{

	@Autowired
	HistoryDefectRepository historyDefectRepository;
	
	@Override
	public void updateDefect(Defect defect, User user) {
		HistoryDefect hd = new HistoryDefect(defect, new Date(System.currentTimeMillis()), user, "update");
		historyDefectRepository.save(hd);
		
	}

	@Override
	public void createDefect(Defect defect, User user) {
		HistoryDefect hd = new HistoryDefect(defect, new Date(System.currentTimeMillis()), user, "create");
		historyDefectRepository.save(hd);
		
	}

	@Override
	public void deleteDefect(Defect defect, User user) {
		HistoryDefect hd = new HistoryDefect(defect, new Date(System.currentTimeMillis()), user, "delete");
		historyDefectRepository.save(hd);
		
	}

	@Override
	public List<HistoryDefect> findByDefectName(String defectName) {
		// TODO Auto-generated method stub
		return historyDefectRepository.findByDefectName(defectName);
	}

	
}
