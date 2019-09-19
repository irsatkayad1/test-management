package com.example.securudemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.service.role.UserService;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "http://localhost:3000")
public class RestApiController {
	
    @Autowired
    private UserService userService;
    
    
    
}
