package com.springboot.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.shiro.service.UsersService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/login")
	public String login(){
		String password = request.getParameter("");
	}
	
}
