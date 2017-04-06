package com.springboot.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.ItemDao;
import com.springboot.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	private static Logger logger = Logger.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private ItemDao itemDao;

	/* (non-Javadoc)
	 * @see com.springboot.services.ItemService#findAll()
	 * 
	 * 测试返回map
	 * 
	 */
	@Transactional
	@Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
	public List<Map<String, Object>> findAll() {
		logger.info("=====================================无缓存调用这里");
		return itemDao.findAll();
	}

	@Transactional
	public List<Map<String, Object>> findAll(Integer page, Integer rows) {
		return itemDao.findAll(page, rows);
	}

}
