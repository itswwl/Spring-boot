package spring.boot.mongodb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mon1")
public class MongoDBController1 {

	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
}
