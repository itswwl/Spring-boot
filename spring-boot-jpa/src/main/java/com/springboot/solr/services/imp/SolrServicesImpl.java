package com.springboot.solr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.solr.domain.Product;
import com.springboot.solr.repository.ProductRepository;
import com.springboot.solr.services.ISolrServices;

@Service
public class SolrServicesImpl implements ISolrServices {
	
	@Autowired
	ProductRepository productRepository;
	 
	public String save(Product product) {
	       productRepository.save(product);
	       return "save";
	}

}
