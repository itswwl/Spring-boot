package com.springboot.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.IItemDao;
import com.springboot.domain.Items;
import com.springboot.services.IItemServices;

@Service
public class ItemServicesImpl implements IItemServices {

	private static Logger logger = Logger.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private IItemDao itemDao;
	
	@Transactional
	@Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
	public List<Items> findAll() {
		logger.info("=====================================无缓存调用这里=======================");
		return (List<Items>) itemDao.findAll();
	}
	

}
