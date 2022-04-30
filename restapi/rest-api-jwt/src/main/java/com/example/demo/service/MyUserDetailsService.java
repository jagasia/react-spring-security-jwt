package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new User("raja","raja",new ArrayList<>());
		System.out.println("Validating......."+username);
		MyUser result = ur.findById(username).get();
		System.out.println(".........................."+result.getUsername());
		return result;
	}

}
