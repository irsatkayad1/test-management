package com.example.securudemo.model.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.securudemo.model.role.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "defect")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "defect_name")
	private String defectName;
	
	@Column(name = "summary")
	private String summary;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name = "step")
	private Step step;
	
	@ManyToOne
	@JoinColumn(name = "test_case")
	private TestCase testCase;
	
	@ManyToOne
	@JoinColumn(name = "requirement")
	private Requirement requirement;

	@ManyToOne
	@JoinColumn(name = "project")
	private Project project;
}
