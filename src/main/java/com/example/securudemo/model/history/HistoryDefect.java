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

import com.example.securudemo.model.project.Defect;
import com.example.securudemo.model.role.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "history_defect")
public class HistoryDefect {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "defect_name")
	private String defectName;
	
	@Column(name = "status")	
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "developer_comment")
	private String developerComment;
			
	@Column(name = "change_date")
	private Date changeDate;
	
	@ManyToOne
	@JoinColumn(name = "changed_by")
	private User changedBy;
	
	private String changeType;

	public HistoryDefect(Defect defect, Date changeDate, User changedBy, String changeType) {
		super();
		
		this.defectName = defect.getDefectName();
		this.description = defect.getDescription();
		this.status = defect.getStatus();
		this.developerComment = defect.getDeveloperComment();
		
		this.changeDate = changeDate;
		this.changedBy = changedBy;
		this.changeType = changeType;
	} 
	
	
}
