package com.example.securudemo.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.project.Defect;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long>  {

	Defect findByDefectName(String defectName);
	
}
