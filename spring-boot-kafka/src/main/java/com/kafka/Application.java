package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * 
 * 
 * Windowsƽ̨��kafka�����Ĵ https://www.2cto.com/net/201701/588235.html
 * http://kafka.apache.org/quickstart
 * 
 * 
 * Start the server
 * 
 * bin\windows\zookeeper-server-start.bat config\zookeeper.properties
 * 
 * bin\windows\kafka-server-start.bat config\server.properties
 * 
 * 
 * Create a topic
 * 
 * 
 * bin\windows\kafka-topics.bat --create --zookeeper localhost:2181
 * --replication-factor 1 --partitions 1 --topic test
 * 
 * bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
 * 
 * 
 * Send some messages
 * 
 * bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic
 * test
 * 
 * 
 * Start a consumer
 * 
 * bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092
 * --topic test --from-beginning
 * 
 * 
 * 
 * spring boot + kafka
 * https://www.cnblogs.com/kangoroo/p/7353330.html
 * 
 * 
 * java kafka
 * http://blog.csdn.net/lnho2015/article/details/51353936
 * 
 * 
 * @author root
 *
 */

@SpringBootApplication
@EnableKafka
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
