package com.springboot.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.dao.IUserDao;
import com.springboot.domain.Users;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {Application.class})
@ContextConfiguration
public class UserRepositoryTest {
	
	@Autowired
	@Qualifier("userDaoImpl")
	private IUserDao userDao;
	
	@Test
	public void testUserDao(){
		List<Users> user = userDao.getAll();
		System.out.println("================="+user);
	}
	
	
	
}
