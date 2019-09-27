package com.example.securudemo.repository.history;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securudemo.model.history.HistoryDefect;

public interface HistoryDefectRepository extends JpaRepository<HistoryDefect, Long>{
	
	List<HistoryDefect> findByDefectName(String defectName);

}
