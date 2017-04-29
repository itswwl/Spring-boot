package spring.boot.mongodb.service;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.mongodb.dao.ICustomerMorphiaDao;
import spring.boot.mongodb.entity.CustomerMorphia;


@Service
public class CustomerMorphiaService {

	@Autowired
	private ICustomerMorphiaDao customerMorphiaDao;
	
	public Key<CustomerMorphia> save(CustomerMorphia customerMorphia){
		return this.customerMorphiaDao.save(customerMorphia);
	}
	
	public UpdateResults update(CustomerMorphia customerMorphia){
		return this.customerMorphiaDao.update(customerMorphia);
	}
	
	public CustomerMorphia findById(String objid){
		return this.customerMorphiaDao.findById(objid);
	}
	
	public void delete(String objid){
		this.customerMorphiaDao.delete(objid);
	}
	
}
