package com.springboot.dao;


import org.springframework.stereotype.Repository;

import com.springboot.domain.Items;

@Repository
public interface IItemDao extends BaseDao<Items, Integer> {
	
}
