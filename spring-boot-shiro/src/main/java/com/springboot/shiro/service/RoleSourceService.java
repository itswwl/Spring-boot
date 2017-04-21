package com.springboot.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.shiro.dao.RoleSourceDao;

@Service
public class RoleSourceService {

	@Autowired
	private RoleSourceDao roleSourceDao;
	
}
