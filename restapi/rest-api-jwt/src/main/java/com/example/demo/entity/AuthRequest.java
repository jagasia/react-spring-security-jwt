package com.example.demo.entity;

public class AuthRequest {
	private String username;
	private String password;
	
	public AuthRequest() {}

	public AuthRequest(String username) {
		super();
		this.username = username;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
