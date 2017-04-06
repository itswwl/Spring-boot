package com.springboot.dao;

import java.util.List;

import com.springboot.domain.Users;

public interface IUserDao  {

	public List<Users> getAll() ;
	
	public Users getUser(String username,String password);
	
	public Users findById(Integer id);
	
	public int updateUsers(Users users);
	
	public int insertUsers(Users users);
	
}