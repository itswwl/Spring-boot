package com.springboot.solr.domain;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by Admin.
 * User: Admin
 * Date: 10/1/2015
 * Time: 8:47 PM
 */
@SolrDocument(solrCoreName = "collection1")
public class Product {

    @Id
    @Field
    private String id;

    @Field
    @Indexed
    private String name;

    public Product() {
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}