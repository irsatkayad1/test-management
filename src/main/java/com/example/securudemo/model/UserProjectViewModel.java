package com.example.securudemo.model;
import java.util.List;

import com.example.securudemo.model.project.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserProjectViewModel {

	private Project project;
	
	private List<String> userName;
	
}
