package com.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.springboot.domain.ItemDetails;

public interface IItemDetailsDao extends BaseDao<ItemDetails, Integer> {
	
	@Query("select itemDetails from ItemDetails itemDetails where itemDetails.id=?1")
	public Page<ItemDetails> getPageById(Integer id,Pageable pageable);
	

}
