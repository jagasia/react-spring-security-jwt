package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.util.JwtUtil;

class Result
{
	public String jwt;
}


class Reply
{
	public String str;
}

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"})
public class MyController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		String username=request.getAttribute("username").toString();
		return "Hello welcome to spring security jwt demo Logged in by "+username;
	}

	@GetMapping("/hi")
	public Reply hi()
	{
		Reply reply=new Reply();
		reply.str="Hi this is fine";
		return reply;
	}
	
	@PostMapping("/authenticate")
	public Result authenticate(@RequestBody AuthRequest authRequest) throws Exception {
		System.out.println(".............."+authRequest.getUsername());
		Authentication authentication=null;
        try {
        	System.out.println("This is try");
           authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password........................................");
        }
		String str = jwtUtil.generateToken(authRequest.getUsername());
		System.out.println(str);
		Result result=new Result();
		result.jwt=str;
		return result;
	}
}
