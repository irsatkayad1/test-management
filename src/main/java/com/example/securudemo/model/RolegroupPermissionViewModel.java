package com.example.securudemo.model;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RolegroupPermissionViewModel {
	
	private String roleGroupName;
	
	private List<String> permissionNames;

}
