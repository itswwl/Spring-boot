package com.springboot;


import org.springframework.boot.SpringApplication;

import com.springboot.resources.Resources;
/**
 * @author Administrator
 * 
 * 程序主入口
 *
 */
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
