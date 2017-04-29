package spring.boot.mongodb.controller;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.mongodb.entity.CustomerMorphia;
import spring.boot.mongodb.service.CustomerMorphiaService;

@RestController
@RequestMapping("/morphia")
public class CustomerMorphiaController {

	@Autowired
	private CustomerMorphiaService customerMorphiaService;
	
	@RequestMapping("/findByID/{objid}")
	public CustomerMorphia findByID(@PathVariable("objid") String objid){
		return this.customerMorphiaService.findById(objid);
	}
	
	@RequestMapping("/save")
	public Key<CustomerMorphia> save(){
		CustomerMorphia customerMorphia = new CustomerMorphia();
		customerMorphia.setFirstname("saveCustomerMon");
		customerMorphia.setSecondname("saveCustomerMon");
		return this.customerMorphiaService.save(customerMorphia);
	}
	
	@RequestMapping("/update")
	public UpdateResults update(){
		CustomerMorphia customerMorphia = new CustomerMorphia();
		customerMorphia.setId(new ObjectId("5904806c6f4df7c5cc804a5f"));
		customerMorphia.setFirstname("customerMorphia2");
		customerMorphia.setSecondname("customerMorphia2");
		return this.customerMorphiaService.update(customerMorphia);
	}
	
	@RequestMapping("/delete")
	public void delete(){
		this.customerMorphiaService.delete("590471066f4dbff26e3fc6b2");
	}
	
}
