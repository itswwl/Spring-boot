package com.springboot.services;

import java.util.List;

import com.springboot.domain.Users;

public interface IUserServices {

	List<Users> getAll();
	
	public Users getUser(String username, String password);
	
	public Users findById(Integer id);
	
	public Boolean updateUsers(Users users);
	
	public Boolean insertUsers(Users users);

}