package com.example.securudemo.model.role;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "user_name")
	private String userName;

	@Column(nullable = false, name = "password")
	private String password;
	
	private int active;


	public User(String userName, String password) {
		
		this.userName=userName;
		this.password=password;	
		this.active = 1;
	}
	
}
