package spring.boot.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spring.boot.mongodb.entity.CustomerMon;

@Repository
public interface CustomerMonDao extends MongoRepository<CustomerMon, String> {

}
