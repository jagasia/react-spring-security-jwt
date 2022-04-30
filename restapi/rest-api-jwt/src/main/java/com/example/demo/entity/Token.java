package com.example.demo.entity;

public class Token {
	private String jwt;
	
	public Token() {}

	public Token(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
