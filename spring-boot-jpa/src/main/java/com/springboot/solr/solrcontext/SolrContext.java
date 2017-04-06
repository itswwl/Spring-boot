package com.springboot.solr.solrcontext;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.repository.support.SolrRepositoryFactory;

import com.springboot.solr.repository.ProductRepository;

/**
 * Created by Admin.
 * User: Admin
 * Date: 10/1/2015
 * Time: 9:19 PM
 */
@Configuration
@EnableSolrRepositories(basePackages = "com.springboot.solr.repository", multicoreSupport = true)
public class SolrContext {

    @Autowired
    SolrServer solrServer;

    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrServer);
    }

    @Bean
    public ProductRepository productRepository() {
        return new SolrRepositoryFactory(solrTemplate())
                .getRepository(ProductRepository.class);
    }

}