package com.springboot.services;

import java.util.List;

import com.springboot.domain.Orders;

public interface IOrdersServices {
	
	public List<Orders> findAll();

}
