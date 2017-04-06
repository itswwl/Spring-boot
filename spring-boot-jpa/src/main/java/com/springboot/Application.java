package com.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springboot.resources.Resources;
/**
 * @author Administrator
 * 
 * 程序主入口
 *
 */
@Configuration
@SpringBootApplication
//@ComponentScan(basePackages={"com.springboot.base","com.springboot.config","com.springboot.dao","com.springboot.services","com.springboot.controller"})
@ComponentScan(basePackages={"com.springboot."})
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		//第一种启动方式
		 //SpringApplication.run(Resources.class, args);
		//第二种启动方式
		SpringApplication springApplication = new SpringApplication(Resources.class);
		springApplication.setShowBanner(true);
		springApplication.run(args);
	}

}
