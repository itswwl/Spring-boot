package com.springboot.dao.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.Application;
import com.springboot.dao.ItemDao;

/**
 * 
 * 单元测试
 * 
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ItemTest {
	
	private static Logger logger = Logger.getLogger(ItemTest.class);
	
	@Autowired
	private ItemDao itemDao;
	
	
	@Test
	public void find(){
		List<Map<String,Object>> list = itemDao.findAll();
		logger.info("========================================================================"+list.size());
	}

}
