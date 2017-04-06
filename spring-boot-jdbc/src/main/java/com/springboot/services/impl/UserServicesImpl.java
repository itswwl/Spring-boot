package com.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.IUserDao;
import com.springboot.domain.Users;
import com.springboot.services.IUserServices;

@Service(value="userServicesImpl")
public class UserServicesImpl implements IUserServices {
	
	private static Logger logger = Logger.getLogger(UserServicesImpl.class);
	
	@Autowired
	@Qualifier("userDaoImpl")
	private IUserDao userDao;
	
	@Override
	@Transactional
	@Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
	public List<Users> getAll(){
		List<Users> users = new ArrayList<Users>();
    	Users user = new Users();
    	user.setId(12);
    	user.setUsername("username");
    	user.setPassowrd("passowrd");
    	users.add(user);
    	//return users;
    	logger.info("========================无缓存的时候调用这里");
    	return userDao.getAll();
	}

	@Override
	@Transactional
	public Users getUser(String username, String password) {
		Users user = userDao.getUser(username, password);
		return user;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Users findById(Integer id) {
		Users users = userDao.findById(id);
		return users;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Boolean updateUsers(Users users) {
		int flag = userDao.updateUsers(users);
		if(flag >= 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Boolean insertUsers(Users users) {
		int flag = userDao.insertUsers(users);
		if(flag >= 0){
			return true;
		}else{
			return false;
		}
	}

}
