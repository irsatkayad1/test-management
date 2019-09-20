package com.example.securudemo.service.history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.history.HistoryProject;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.history.HistoryProjectRepository;

@Service
public class HistoryProjectServiceImpl implements HistoryProjectService{

	@Autowired
	HistoryProjectRepository historyProjectRepository;

	@Override
	public void createProject(Project project, User user) {
		HistoryProject hp = new HistoryProject(project, new Date(System.currentTimeMillis()), user, "create");
		historyProjectRepository.save(hp);
		
	}

	@Override
	public void deleteProject(Project project, User user) {
		
		/*proje delete olursa bağlı tablodaki verilerinde silinmesi gerekir.
			delete edilmeden önce history'e eklenmesi gerekir*/
		HistoryProject hp = new HistoryProject(project, new Date(System.currentTimeMillis()), user, "delete");
		historyProjectRepository.save(hp);
		
	}

	
	@Override
	public List<HistoryProject> findByProjectName(String projectName) {
		
		//görüntüleyenler için history tutulacak mı?
		return historyProjectRepository.findByProjectName(projectName);
	}

	@Override
	public void updateProject(Project project, User user) {
		HistoryProject hp = new HistoryProject(project, new Date(System.currentTimeMillis()), user, "update");
		historyProjectRepository.save(hp);
		
	}
	
	
	
	

}
