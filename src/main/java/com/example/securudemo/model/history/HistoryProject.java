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
	
	@ManyToOne
	@JoinColumn(name = "project")
	private Project project;
	
	@Column(name = "change_date")
	private Date changeDate;
	
	@ManyToOne
	@JoinColumn(name = "changed_by")
	private User changedBy;

	public HistoryProject(Project project, Date changeDate, User changedBy) {
		super();
		this.project = project;
		this.changeDate = changeDate;
		this.changedBy = changedBy;
	}
	
	

}
