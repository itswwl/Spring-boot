package com.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.IOrdersDao;
import com.springboot.domain.Orders;
import com.springboot.services.IOrdersServices;

@Service
public class OrdersServicesImpl implements IOrdersServices {
	
	@Autowired
	private IOrdersDao ordersDao;

	@Transactional
	public List<Orders> findAll() {
		return (List<Orders>) ordersDao.findAll();
	}

}
