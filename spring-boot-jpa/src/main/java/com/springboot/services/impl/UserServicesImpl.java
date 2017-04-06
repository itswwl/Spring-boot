package com.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.IUserDao;
import com.springboot.domain.Users;
import com.springboot.services.IUserServices;

@Service
public class UserServicesImpl implements IUserServices {
	
	private static Logger logger = Logger.getLogger(UserServicesImpl.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Transactional
	@Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
	public List<Users> findAll(){
		List<Users> users = new ArrayList<Users>();
    	Users user = new Users();
    	user.setId(12);
    	user.setUsername("username");
    	user.setPassword("passowrd");
    	users.add(user);
    	//return users;
    	logger.info("========================无缓存的时候调用这里");
    	return (List<Users>) userDao.findAll();
	}

	@Transactional
	public Users getUser(String username,String password) {
		Users user = userDao.getUser(username);
		if(user!=null){
			if(user.getPassword().equals(password)){
				logger.info("================="+user.getPassword()+"========="+user.getUsername());
				return user;
			}else{
				return null;
			}
		}
		return user;
	}

	@Transactional(rollbackFor=Exception.class)
	public Users findById(Integer id) {
		Users users = userDao.findOne(id);
		return users;
	}

	@Transactional(rollbackFor=Exception.class)
	public Boolean updateUsers(Users users) {
		Users user = userDao.save(users);
		if(user!=null){
			return true;
		}else{
			return false;
		}
	}

	@Transactional(rollbackFor=Exception.class)
	public Boolean insertUsers(Users users) {
		Users user = userDao.save(users);
		if(user!=null){
			return true;
		}else{
			return false;
		}
	}

}
