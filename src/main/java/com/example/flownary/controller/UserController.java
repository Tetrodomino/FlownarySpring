package com.example.flownary.controller;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.flownary.entity.User;
import com.example.flownary.service.UserService;

@Controller
public class UserController {

	@Autowired private UserService userSvc;
	
	@GetMapping("/user/register")
	public void userRegister(@RequestParam String email, @RequestParam String pwd) {
		
		String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
		
		User user = new User(email, hashedPwd);
		
		userSvc.insertUser(user);
		
	}
}
