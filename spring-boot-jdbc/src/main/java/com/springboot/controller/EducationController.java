package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/springboot/education")
public class EducationController {
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		return "index";
	}

}
