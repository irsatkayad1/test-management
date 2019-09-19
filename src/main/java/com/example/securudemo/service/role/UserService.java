package com.example.securudemo.service.role;

import java.util.List;

import com.example.securudemo.model.UserRolePermissionViewModel;
import com.example.securudemo.model.role.User;

public interface UserService {

	List<User> findAll();
	
	void createUser(UserRolePermissionViewModel userRolePermissionViewModel);
	
	void deleteUser(Long userId);
	
	User findByUserName(String userName);
	
	
}
