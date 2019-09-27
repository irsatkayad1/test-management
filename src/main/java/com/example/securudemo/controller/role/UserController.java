package com.example.securudemo.controller.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.CurrentUser;
import com.example.securudemo.model.UserRolePermissionViewModel;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.role.UserRepository;
import com.example.securudemo.service.role.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	
	
	
	@PostMapping("create")
	public void createUser(@RequestBody UserRolePermissionViewModel userRolePermissionViewModel) {
		System.out.println(CurrentUser.userName());
		userService.createUser(userRolePermissionViewModel);
		
	}
	
	@GetMapping("get_all_users")
    public List<User> users(){
        return userService.findAll();
                
    }
	
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		System.out.println(id);
		userService.deleteUser(id);
		
		
	}
	
	@GetMapping("getByUsername")
	public User getUserByUserName(@RequestBody String userName) {
		
		
		return userService.findByUserName(userName);
		
	}
	
	@PutMapping("update/{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		
		return userRepository.findById(id).map(user ->{
			user.setActive(newUser.getActive());
			user.setUserName(newUser.getUserName());
			user.setPassword(passwordEncoder.encode(newUser.getPassword()));
			return userRepository.save(user);
		}).orElseGet(()->{
			newUser.setId(id);
			return userRepository.save(newUser);
		});
		
	}
}
