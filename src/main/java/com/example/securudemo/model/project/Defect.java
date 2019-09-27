package com.example.securudemo.model.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.model.role.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
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
	
	@Column(name = "status")	
	private String status;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "phase_found")
	private String phaseFound;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "developer_comment")
	private String developerComment;
	
	@Column(name = "type")
	private String type;
	
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
	
	@ManyToOne
	@JoinColumn(name = "assigneeTo")
	private User assigneeTo;
	
	@ManyToOne
	@JoinColumn(name = "assignee_to_group")
	private RoleGroup assigneeToGroup;
		
}
