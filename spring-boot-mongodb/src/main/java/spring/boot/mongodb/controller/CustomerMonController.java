package spring.boot.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.mongodb.entity.CustomerMon;
import spring.boot.mongodb.service.CustomerMonService;

@RestController
@RequestMapping("/mon")
public class CustomerMonController {
	
	@Autowired
	private CustomerMonService customerMonService;

	@RequestMapping("/findByID/{objid}")
	public CustomerMon findByID(@PathVariable("objid") String objid){
		return this.customerMonService.findById(objid);
	}
	
	@RequestMapping("/save")
	public CustomerMon save(){
		CustomerMon customerMon = new CustomerMon();
		customerMon.setFirstname("saveCustomerMon");
		customerMon.setSecondname("saveCustomerMon");
		return this.customerMonService.save(customerMon);
	}
	
	@RequestMapping("/update")
	public CustomerMon update(){
		CustomerMon customerMon = new CustomerMon();
		customerMon.setId("59021228fcd16f9069812fd4");
		customerMon.setFirstname("saveCustomerMon2");
		customerMon.setSecondname("saveCustomerMon2");
		return this.customerMonService.update(customerMon);
	}
	
	@RequestMapping("/delete")
	public void delete(){
		this.customerMonService.delete("590463776f4d6129e61d7243");
	}
	
}
