package com.example.securudemo.model.project;

import java.util.Date;

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
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "project_name", nullable = false)
	private String projectName;
	
	@Column(name = "ex_start_date")
	private Date exStartDate;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "ex_end_date")
	private Date exEndDate;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	public Project(String projectName, Date exStartDate, Date exEndDate, String status) {
		super();
		this.projectName = projectName;
		this.exStartDate = exStartDate;
		this.createDate = new Date(System.currentTimeMillis());
		this.exEndDate = exEndDate;
		this.status = status;
		
	}
	
}
