package com.example.securudemo.model.project;

import java.sql.Date;

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
@Table(name = "mile_stone")
public class MileStone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "mile_stone_name", nullable = false)
	private String mileStoneName;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
}
