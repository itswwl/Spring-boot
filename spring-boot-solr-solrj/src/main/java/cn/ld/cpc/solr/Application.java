package cn.ld.cpc.solr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("cn.ld.cpc.solr.model")
@EnableJpaRepositories(basePackages ={"cn.ld.cpc.solr.dao"})
@ComponentScan(basePackages ={"cn.ld.cpc.solr.controller","cn.ld.cpc.solr.setting","cn.ld.cpc.solr.dao","cn.ld.cpc.solr.service"})
//@EnableScheduling//启动定时任务
public class Application {

	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
	
}
