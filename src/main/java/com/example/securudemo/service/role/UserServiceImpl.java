package com.example.securudemo.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.UserRolePermissionViewModel;
import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.project.ProjectRepository;
import com.example.securudemo.repository.role.PermissionRepository;
import com.example.securudemo.repository.role.RoleGroupRepository;
import com.example.securudemo.repository.role.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleGroupRepository roleGroupRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Secured("ROLE_READ-USER")
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	
	
	@Override
	@Secured("ROLE_CREATE-USER")
	public void createUser(UserRolePermissionViewModel userRolePermissionViewModel) {
		
		System.out.println("Eklenecek User : "+userRolePermissionViewModel.getUser());
		System.out.println("Eklenecek User'ın RoleGroup'u : "+userRolePermissionViewModel.getRoleGroups());
		
		//User Oluşturuldu
		User newUser = new User(userRolePermissionViewModel.getUser().getUserName(),passwordEncoder.encode(userRolePermissionViewModel.getUser().getPassword()));
		userRepository.save(newUser);		
		
		//Yeni User için Yeni RoleGroup'lar Oluşturuldu
		List<String> roleGroupsList = userRolePermissionViewModel.getRoleGroups();
		for (String roleGroupName : roleGroupsList) {
			RoleGroup newRoleGroup = new RoleGroup(roleGroupName, newUser);
			roleGroupRepository.save(newRoleGroup);
			
			//Yeni Eklenen User'a bir roleGroup seçildi. Bu RoleGroup'un idSi farklı olduğu için yeni RoleGroup id'si ile permissionlar tekrar eklenmeli
			List<Permission> permList = permissionRepository.findByRoleGroup(roleGroupRepository.findByRoleGroupName(roleGroupName).get(0));
			
			/*Yeni User için Yeni bir ROleGroup oluşturuldu. ve Bu yeni oluşturulan RoleGroup'un ismi aynı olsa da id'si farklı
			bunun için yeni id'ye sahip roleGroup için Permissionlar tekrar tanımlanıyor*/
			for (Permission perm : permList) {
				Permission permission = new Permission(perm.getPermissionName(), newRoleGroup);
				permissionRepository.save(permission);
			}
		}		
	}

	@Secured("ROLE_DELETE-USER")
	@Override
	public void deleteUser(Long userId) {
	
		userRepository.deleteById(userId);
		
	}
	
	@Secured("ROLE_READ-USER")
	@Override
	public User findByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	
	}




}
