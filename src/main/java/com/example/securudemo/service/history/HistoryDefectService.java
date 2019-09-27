package com.example.securudemo.service.history;

import java.util.List;


import com.example.securudemo.model.history.HistoryDefect;
import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.role.User;



public interface HistoryDefectService {

	void updateDefect(Defect defect, User user);

	void createDefect(Defect defect, User user);

	void deleteDefect(Defect defect, User user);

	List<HistoryDefect> findByDefectName(String defectName);
}
