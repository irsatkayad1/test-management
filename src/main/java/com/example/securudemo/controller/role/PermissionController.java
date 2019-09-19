package com.example.securudemo.controller.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.role.Permission;
import com.example.securudemo.repository.role.PermissionRepository;
import com.example.securudemo.service.role.PermissionService;

@RestController
@RequestMapping("permission")
@CrossOrigin(origins = "http://localhost:3000")
public class PermissionController {
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	PermissionService permissionService;

	@PostMapping("create")
	public void createPermission(@RequestBody Permission permission) {
		
		permissionService.createPermission(permission);
		
	}
	
	@GetMapping("get_all_permissions")
	public List<Permission> getAllPermissions(){
		
		return permissionService.getAllPermissions();
		
	}
	@GetMapping("get/{permissionName}")
	public Permission getPermissionByPermissionName(@PathVariable String permissionName) {
		
		return permissionService.findByPermissionName(permissionName);
		
	}
	
	@PutMapping("update/{id}")
	public Permission updatePermission(@RequestBody Permission newPermission, @PathVariable Long id) {
		
		return permissionRepository.findById(id).map(permission ->{
			permission.setPermissionName(newPermission.getPermissionName());
			permission.setRoleGroup(newPermission.getRoleGroup());
			return permissionRepository.save(permission);
		}).orElseGet(()->{
			newPermission.setId(id);
			return permissionRepository.save(newPermission);
		});
		
	}
}
