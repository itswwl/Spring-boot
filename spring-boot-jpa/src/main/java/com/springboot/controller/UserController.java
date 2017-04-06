package com.springboot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.domain.Users;
import com.springboot.services.IUserServices;

/**
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/springboot/user")
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	@Qualifier(value = "userServicesImpl")
	private IUserServices userServices;
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@RequestParam(value="username")String username, @RequestParam(value="password")String password){
		Users users = new Users();
		users.setUsername(username);
		users.setPassword(password);
		Boolean flag = userServices.insertUsers(users);
		if(flag){
			return "login";
		}else{
			return "redirect:/html/register.html";
		}
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateUsers(@ModelAttribute Users users,Model model){
		logger.info("=============="+users.getId()+"============="+users.getPassword());
		Boolean flag = userServices.updateUsers(users);
		if(flag){
			return "redirect:/springboot/user/all";
		}else{
			model.addAttribute("user",users);
			return "update";
		}
		
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam(value="username")String username, @RequestParam(value="password")String password,Model model){
		Users user = userServices.getUser(username, password);
		if(user != null){
			model.addAttribute("user",user);
			return "update";
			//return "redirect:/springboot/user/all";
		}else{
			return "login";
		}
	}
    
    @RequestMapping("/all")
    @ResponseBody
    public List<Users> getAll(){
    	logger.info("========================无缓存调用这里测试all");
    	return userServices.findAll();
	}
    
    /**
     * 
     * 测试redis是否缓存
     * 测试成功
     * @return
     */
    @RequestMapping("/all2")
    @ResponseBody
    public List<Users> getAll2(){
    	logger.info("========================没有执行查询all2");
    	return userServices.findAll();
	}

}
