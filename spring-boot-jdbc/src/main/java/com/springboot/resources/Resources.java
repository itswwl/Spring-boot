package com.springboot.resources;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springboot.controller.EducationController;
import com.springboot.controller.IndexController;
import com.springboot.controller.UserController;

@Configuration
@SpringBootApplication
//@ComponentScan(basePackages={"com.springboot.base","com.springboot.config","com.springboot.dao","com.springboot.services","com.springboot.controller"})
@ComponentScan(basePackages={"com.springboot."})
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class Resources {
	
	@Resource
	private UserController userController;
	
	@Resource
	private EducationController educationController;
	
	@Resource
	private IndexController indexController;
	
}
