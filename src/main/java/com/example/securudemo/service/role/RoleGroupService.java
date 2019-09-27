package com.example.securudemo.service.role;


import java.util.List;

import com.example.securudemo.model.RolegroupPermissionViewModel;
import com.example.securudemo.model.role.RoleGroup;

public interface RoleGroupService {

	void createRoleGroup(RolegroupPermissionViewModel rolegroupPermissionViewModel);
	
	List<RoleGroup> getAllRoleGroups();
	
	void deleteRoleGroup(Long roleGroupId);

	List<RoleGroup> findByRoleGroupName(String roleGroupName);
	
	
}
