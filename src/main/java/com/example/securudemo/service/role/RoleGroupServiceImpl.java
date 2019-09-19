package com.example.securudemo.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.RolegroupPermissionViewModel;
import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.repository.role.PermissionRepository;
import com.example.securudemo.repository.role.RoleGroupRepository;

@Service
public class RoleGroupServiceImpl implements RoleGroupService{

	@Autowired
	RoleGroupRepository roleGroupRepository;
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Secured("ROLE_CREATE-ROLEGROUP")
	@Override
	public void createRoleGroup(RolegroupPermissionViewModel rolegroupPermissionViewModel) {
	
		System.out.println("RoleGroupServiceImpl | getRoleGroupName : "+rolegroupPermissionViewModel.getRoleGroupName());
		System.out.println("RoleGroupServiceImpl | getPermissionNames List : "+rolegroupPermissionViewModel.getPermissionNames());
		
		RoleGroup rg = new RoleGroup();
		rg.setRoleGroupName(rolegroupPermissionViewModel.getRoleGroupName());
		roleGroupRepository.save(rg);
		System.out.println("Created RoleGroup : "+roleGroupRepository.findByRoleGroupName(rolegroupPermissionViewModel.getRoleGroupName()));
		
		for (String perm : rolegroupPermissionViewModel.getPermissionNames()) {
			Permission permission = new Permission(perm, rg);
			permissionRepository.save(permission);			
		}
		
		
	}
	
	@Secured("ROLE_READ-ROLEGROUP")
	@Override
	public List<RoleGroup> getAllRoleGroups() {
	
		return roleGroupRepository.findAll();
	
	}
	
	@Secured("ROLE_DELETE-ROLEGROUP")
	@Override
	public void deleteRoleGroup(Long roleGroupId) {
		
		roleGroupRepository.deleteById(roleGroupId);
		
	}

	@Override
	public RoleGroup findByRoleGroupName(String roleGroupName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
