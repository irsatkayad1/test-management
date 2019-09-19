package com.example.securudemo.repository.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.RoleGroup;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{
	
	Permission findByPermissionName(String permissionName);
	
	List<Permission> findByRoleGroup(RoleGroup roleGroup);
	

}
