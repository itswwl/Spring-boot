package spring.boot.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.mongodb.dao.CustomerMonDao;
import spring.boot.mongodb.entity.CustomerMon;


@Service
public class CustomerMonService {

	@Autowired
	private CustomerMonDao customerMonDao;
	
	public CustomerMon save(CustomerMon customerMon){
		return this.customerMonDao.save(customerMon);
	}
	
	public CustomerMon update(CustomerMon customerMon){
		return this.customerMonDao.save(customerMon);
	}
	
	public CustomerMon findById(String objid){
		return this.customerMonDao.findOne(objid);
	}
	
	public void delete(String objid){
		this.customerMonDao.delete(objid);
	}
	
}
