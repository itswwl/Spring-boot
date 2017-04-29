package spring.boot.mongodb.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateResults;

import spring.boot.mongodb.entity.CustomerMorphia;


public interface ICustomerMorphiaDao {

	public Key<CustomerMorphia> save(CustomerMorphia customerMorphia);
	
	public UpdateResults update(CustomerMorphia customerMorphia);
	
	public CustomerMorphia findById(String objid);
	
	public void delete(String objid);
	
}
