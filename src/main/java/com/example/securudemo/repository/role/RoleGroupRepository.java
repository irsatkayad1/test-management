package com.example.securudemo.repository.role;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.model.role.User;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long>{

	
	List<RoleGroup> findByRoleGroupName(String roleName);
	
	List<RoleGroup> findByUserId(User userId);
	
}
