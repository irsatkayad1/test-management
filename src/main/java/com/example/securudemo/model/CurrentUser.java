package com.example.securudemo.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {
	
	public static String userName(){
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authentication == null ? null : authentication.getName();
	  }

}
