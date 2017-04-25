package com.springboot.shiro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.shiro.entry.Sources;
import com.springboot.shiro.pojo.SessionUser;
import com.springboot.shiro.pojo.UserSecurity;

@Controller
public class MainController {
	
//	@RequestMapping("/login")
//	public String login(){
//		return "login";
//	}
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/main/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/")
	public String root(){
		return "login";
	}
	
	@RequestMapping("/main/menu/top")
	public String top(Model model){
		SessionUser sessionUser = UserSecurity.getCurrentUser();
		Set<Sources> topSources = new HashSet<>();
		sessionUser.getSources().stream().forEach((item)->{
			if(item.getType()==1){
				topSources.add(item);
			}
			
		});
		//排序
		List<Sources> list = new ArrayList<>(topSources);
		Collections.sort(list);
		model.addAttribute("f", request.getParameter("f"));
		model.addAttribute("topSources", list);
		
//		model.addAttribute("top", "top");
		return "layout";
	}
	
	@RequestMapping("/main/menu/left")
	public String left(Model model){
		Long id = Long.valueOf(request.getParameter("id"));
		SessionUser sessionUser = UserSecurity.getCurrentUser();
		Set<Sources> leftSource = new TreeSet<>();
		
		
		if(sessionUser.getLeftmenu().get(id)!=null){
			leftSource = sessionUser.getLeftmenu().get(id);
		}else{
			Set<Sources> left2 = new TreeSet<>();
			Set<Sources> left3 = new TreeSet<>();
			Set<Sources> sources = sessionUser.getSources();
			sources.stream().forEach((item)->{
				if(item.getPid().equals(id)){
					left2.add(item);
				}
			});
			left2.stream().forEach((item)->{
				sources.stream().forEach((entry)->{
					if(entry.getPid().equals(item.getId())){
						left3.add(entry);
					}
				});
			});
			leftSource.addAll(left2);
			leftSource.addAll(left3);
			sessionUser.addLeftMenu(id, leftSource);
		}
		model.addAttribute("f", request.getParameter("f"));
		model.addAttribute("leftSource", leftSource);
		
		
//		model.addAttribute("left", "left");
		return "layout";
	}
	
//	@RequestMapping("/right")
//	public String right(Model model){
//		model.addAttribute("right", "right");
//		return "layout";
//	}

}
