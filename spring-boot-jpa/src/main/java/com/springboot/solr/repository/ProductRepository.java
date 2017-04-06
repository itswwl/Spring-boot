package com.springboot.solr.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.springboot.solr.domain.Product;

/**
 * Created by Admin.
 * User: Admin
 * Date: 10/1/2015
 * Time: 8:59 PM
 */
public interface ProductRepository extends SolrCrudRepository<Product, String> {
    Product findById(String id);
}
