package com.springboot.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.solr.domain.Product;
import com.springboot.solr.repository.ProductRepository;
import com.springboot.solr.services.ISolrServices;

//@EnableSolrRepositories(basePackages = "org.springboot.")
@Controller
@RequestMapping("/springboot/solr")
public class SolrController {
	
	@Autowired
	ISolrServices solrServices;
	 
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	@ResponseBody
    public String save() throws Exception {
		solrServices.save(new Product("2", "wanglin"));
        return "save";
    }

}
