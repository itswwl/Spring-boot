package com.springboot.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inurl")
public class InurlController {

	private static Logger logger = Logger.getLogger(InurlController.class);
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/getDataView")
	public String getData(Model model){
		model.addAttribute("getData", "getData");
		return "userList";
	}
	
	@RequestMapping("/detailView")
	public String view(Model model){
		model.addAttribute("view", "view");
		return "userList";
	}
	
	@RequestMapping("/update")
	public String update(Model model){
		model.addAttribute("update", "update");
		return "userList";
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id")Long id){
		logger.info(id);
		logger.info(request.getParameter("val"));
		return "{\"flag\":\"success\"}";
	}
	
}
