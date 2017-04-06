package com.springboot.dao;

import java.util.List;
import java.util.Map;


public interface ItemDao {
	
	public List<Map<String,Object>>  findAll();
	
	public List<Map<String,Object>> findAll(Integer page,Integer rows);

}
