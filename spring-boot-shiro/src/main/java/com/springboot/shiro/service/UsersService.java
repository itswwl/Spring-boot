package com.springboot.shiro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.shiro.dao.UsersDao;
import com.springboot.shiro.entry.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Transactional(readOnly = true)
	public Users findOne(Long id){
		return usersDao.findOne(id);
	}

}
