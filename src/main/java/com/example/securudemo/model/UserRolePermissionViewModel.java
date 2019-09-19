package com.example.securudemo.model;

import java.util.List;

import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.model.role.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRolePermissionViewModel {
	
	private User user;
	
	private List<String> roleGroups;
	
	
	
	
}
