package com.springboot.services;

import java.util.List;
import java.util.Map;

public interface ItemService {

	public List<Map<String,Object>>  findAll();
	
	public List<Map<String, Object>> findAll(Integer page, Integer rows);
	
}
