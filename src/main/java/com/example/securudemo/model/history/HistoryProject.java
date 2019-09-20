package com.example.securudemo.model.history;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.role.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "history_project")
public class HistoryProject{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "project_name", nullable = false)
	private String projectName;
	
	@Column(name = "ex_start_date")
	private Date exStartDate;
		
	@Column(name = "ex_end_date")
	private Date exEndDate;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "change_date")
	private Date changeDate;
	
	@ManyToOne
	@JoinColumn(name = "changed_by")
	private User changedBy;
	
	private String changeType; 

	public HistoryProject(Project project, Date changeDate, User changedBy, String changeType) {
		super();
		this.projectName = project.getProjectName();
		this.exStartDate = project.getExStartDate();
		this.exEndDate = project.getExEndDate();
		this.status = project.getStatus();
		this.description = project.getDescription();
		
		this.changeDate = changeDate;
		this.changedBy = changedBy;
		this.changeType = changeType;
	}
	
	

}
