package com.example.securudemo.model.project;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "step")
public class Step {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "step_name", nullable = false)
	private String stepName;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "pre_condition", nullable = false)
	private String preCondition;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "ex_result", nullable = false)
	private String exResult;

	@ManyToOne
	@JoinColumn(name = "test_case_id")
	private TestCase testCase;
	
}
