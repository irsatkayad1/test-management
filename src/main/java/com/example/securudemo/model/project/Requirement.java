package com.example.securudemo.model.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "requirement")
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "requirement_name", nullable = false)
	private String requirementName;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;

	public Requirement(String requirementName) {
		super();
		this.requirementName = requirementName;
		
	}
	
	
	
}
