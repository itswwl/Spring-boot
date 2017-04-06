package cn.ld.cpc.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("cn.ld.cpc.redis.model")
@EnableJpaRepositories(basePackages ={"cn.ld.cpc.redis.dao"})
@ComponentScan(basePackages ={"cn.ld.cpc.redis.controller","cn.ld.cpc.redis.setting","cn.ld.cpc.redis.dao","cn.ld.cpc.redis.service","cn.ld.cpc.redis.model.sys"})
//@EnableScheduling//启动定时任务
public class Application {

	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
	
}
