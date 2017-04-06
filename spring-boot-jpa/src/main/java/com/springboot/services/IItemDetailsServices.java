package com.springboot.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.domain.ItemDetails;
import com.springboot.vo.ItemDetailsVO;

public interface IItemDetailsServices {
	
	public List<ItemDetails> findAll();
	
	public Page<ItemDetails> findAll(Pageable pageable); 
	
	public Page<ItemDetails> getPageById(Integer id,Pageable pageable);
	
	public Page<ItemDetails> getPageById(ItemDetailsVO itemDetailsVO, Pageable pageable);

}
