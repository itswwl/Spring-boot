package com.springboot.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inurl")
public class InurlController {

	
	@RequestMapping("/getData")
	public String getData(Model model){
		model.addAttribute("getData", "getData");
		return "userList";
	}
	
	@RequestMapping("/view")
	public String view(Model model){
		model.addAttribute("view", "view");
		return "userList";
	}
	
	@RequestMapping("/update")
	public String update(Model model){
		model.addAttribute("update", "update");
		return "userList";
	}
	
}
