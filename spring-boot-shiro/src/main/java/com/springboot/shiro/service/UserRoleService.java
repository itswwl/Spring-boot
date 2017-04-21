package com.springboot.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.shiro.dao.UserRoleDao;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;

}
