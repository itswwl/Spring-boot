package com.springboot.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.shiro.dao.RolesDao;

@Service
public class RolesService {
	

	@Autowired
	private RolesDao rolesDao;
	
}
