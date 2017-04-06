package com.springboot.dao;


import org.springframework.data.jpa.repository.Query;

import com.springboot.domain.Users;

public interface IUserDao extends BaseDao<Users, Integer> {

	@Query("from Users u where u.username=?1")
	public Users getUser(String username);
	
}