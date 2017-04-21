package com.springboot.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.shiro.entry.Users;
import com.springboot.shiro.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/findOne/{id}")
	@ResponseBody
	public Users findOne(@PathVariable("id")Long id){
		return usersService.findOne(id);
	}
	
}
