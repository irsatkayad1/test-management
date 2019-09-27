package com.example.securudemo.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.role.Permission;
import com.example.securudemo.repository.role.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	PermissionRepository permissionRepository;
	
	@Secured("ROLE_CREATE-PERMISSION")
	@Override
	public void createPermission(Permission permission) {
	
		permissionRepository.save(permission);
		
	}
	
	@Secured("ROLE_READ-PERMISSION")
	@Override
	public List<Permission> getAllPermissions() {
		
		return permissionRepository.findAll();
		
	}
	
	@Secured("ROLE_DELETE-PERMISSION")
	@Override
	public void deletePermission(Long permissionId) {
		
		permissionRepository.deleteById(permissionId);
		
	}

	@Override
	public Permission findByPermissionName(String permissionName) {
		
		return permissionRepository.findByPermissionName(permissionName);
	}
	
	
	
}
