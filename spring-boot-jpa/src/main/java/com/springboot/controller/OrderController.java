package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.domain.Orders;
import com.springboot.services.IOrdersServices;

@Controller
@RequestMapping("/springboot/orders")
public class OrderController {
	
	@Autowired
	private IOrdersServices orderServices;
	
	@RequestMapping("/")
	@ResponseBody
	public List<Orders> getAll(){
		return orderServices.findAll();
	}

}
