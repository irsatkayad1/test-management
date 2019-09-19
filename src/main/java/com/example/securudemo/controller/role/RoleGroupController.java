package com.example.securudemo.controller.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.RolegroupPermissionViewModel;
import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.repository.role.RoleGroupRepository;
import com.example.securudemo.service.role.RoleGroupService;

@RestController
@RequestMapping("rolegroup")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleGroupController {

	@Autowired
	RoleGroupRepository roleGroupRepository;
	
	@Autowired
	RoleGroupService roleGroupService;
	
	@PostMapping("create")
	public void createRoleGroup(@RequestBody RolegroupPermissionViewModel rolegroupPermissionViewModel) {
		
		roleGroupService.createRoleGroup(rolegroupPermissionViewModel);
		
	}
	
	@GetMapping("get_all_rolegroups")
	public List<RoleGroup> getAllRoleGroup() {
		
		return roleGroupService.getAllRoleGroups();
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteRoleGroup(@PathVariable Long roleGroupId) {
		
		roleGroupService.deleteRoleGroup(roleGroupId);
		
	}
	
	@GetMapping("get/{roleGroupName}")
	public RoleGroup getRoleGroupName(@PathVariable String roleGroupName) {
		
		return roleGroupService.findByRoleGroupName(roleGroupName);
		
	}
	
	@PutMapping("update/{id}")
	public RoleGroup updateRoleGroup(@RequestBody RoleGroup newRoleGroup, @PathVariable Long id) {
		
		return roleGroupRepository.findById(id).map(roleGroup ->{
			roleGroup.setRoleGroupName(newRoleGroup.getRoleGroupName());
			roleGroup.setUserId(newRoleGroup.getUserId());
			return roleGroupRepository.save(roleGroup);
		}).orElseGet(()->{
			newRoleGroup.setId(id);
			return roleGroupRepository.save(newRoleGroup);
		});
		
	}
}
