package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.springboot.domain.Orders;

public interface IOrdersDao extends BaseDao<Orders, Integer> {
	
	@Query("select id, totalPrices from Orders o")
	public List<Orders> findAll();

}
