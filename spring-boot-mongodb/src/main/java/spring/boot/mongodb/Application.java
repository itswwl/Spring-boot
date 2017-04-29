package spring.boot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author root
 * 
 * spring boot mongodb
 * http://www.cnblogs.com/java-zhao/p/5449333.html
 * 不需在mongodb指定创建collection，会自动生成collection，没有指定实体和collection的映射关系
 * 
 * 
 * spring boot整合Morphia对MongoDB进行操作
 * http://blog.csdn.net/u012734441/article/details/51433137
 * 
 * 
 * spring boot morphia
 * http://www.jianshu.com/p/fb8f0b46a03a
 * 
 *
 */
@SpringBootApplication
@ComponentScan("spring.boot.mongodb")
public class Application {
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(Application.class, args);
	}

}
