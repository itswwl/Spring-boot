package com.springboot.shiro.pojo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springboot.shiro.entry.Users;

public class UserSecurity {

	public static SessionUser getCurrentUser() {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (httpServletRequest.getSession().getAttribute("users") == null)
			return null;
		else {
			return (SessionUser) httpServletRequest.getSession().getAttribute("users");
		}
	}

	public static Boolean isLogin() {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (httpServletRequest.getSession().getAttribute("users") == null)
			return Boolean.FALSE;
		else
			return Boolean.TRUE;
	}

	public static void Logout() {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		httpServletRequest.getSession().setAttribute("users", null);
		httpServletRequest.getSession().removeAttribute("users");
	}
	
	public static void addSessionUser(SessionUser user){
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		httpServletRequest.getSession().setAttribute("users", user);
	}
}
