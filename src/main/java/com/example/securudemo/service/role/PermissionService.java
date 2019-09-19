package com.example.securudemo.service.role;

import java.util.List;

import com.example.securudemo.model.role.Permission;

public interface PermissionService {

	void createPermission(Permission permission);
	
	List<Permission> getAllPermissions();
	
	void deletePermission(Long permissionId);

	Permission findByPermissionName(String permissionName);
	
	
}
