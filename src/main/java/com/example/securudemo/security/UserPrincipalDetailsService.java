package com.example.securudemo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.role.PermissionRepository;
import com.example.securudemo.repository.role.RoleGroupRepository;
import com.example.securudemo.repository.role.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleGroupRepository roleGroupRepository;
    
	@Autowired
	private PermissionRepository permissionRepository;

	
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
		 User user = this.userRepository.findByUserName(s);
		
		 List<Permission> permList = new ArrayList<Permission>();
		 try {
			 roleGroupRepository.findByUserId(user).forEach(z->{
				 permissionRepository.findByRoleGroup(z).forEach(p->{
					 permList.add(p);
				 });
				 
			 });
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
	     UserPrincipal userPrincipal = new UserPrincipal(user,permList);

	     return userPrincipal;
	}

}
