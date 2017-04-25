package com.springboot.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.shiro.entry.Users;
import com.springboot.shiro.pojo.SessionUser;
import com.springboot.shiro.pojo.UserSecurity;
import com.springboot.shiro.service.UsersService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UsersService usersService;

	@RequestMapping("/login")
	public String login() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (request.getMethod().equals("GET")) {
			return "login";
		}
		Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()){
        	currentUser.logout();
        }
		// Users users = usersService.login(username, password);
		SessionUser users = usersService.login(username, password);
		if (users != null) {
			UserSecurity.addSessionUser(users);
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			currentUser.login(token);
			return "redirect:/main/index";
		} else {
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String userLogout() {
		UserSecurity.Logout();
		return "redirect:login";
	}

}
