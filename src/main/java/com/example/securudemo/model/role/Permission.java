package com.example.securudemo.model.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "permission")
public class Permission {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "permission_name")
	private String permissionName;
	
	@ManyToOne
	@JoinColumn(name = "role_group_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private RoleGroup roleGroup;

	public Permission(String permissionName, RoleGroup roleGroupName) {
		super();
		this.permissionName = permissionName;
		this.roleGroup = roleGroupName;
	}
	
	
	
	

}
