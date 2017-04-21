package com.springboot.shiro.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.shiro.entry.Users;

@Repository
public interface UsersDao extends BaseDao<Users, Long> {

	@Query(" from Users model where model.username = :n and model.password = :pwd ")
	public Users findByUP(@Param("n")String name,@Param("pwd")String pwd);
	
}
