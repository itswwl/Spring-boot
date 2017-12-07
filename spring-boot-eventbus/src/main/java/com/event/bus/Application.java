package com.event.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import reactor.Environment;
import reactor.bus.EventBus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static reactor.bus.selector.Selectors.$;


/**
 * 
 * 
 * https://spring.io/guides/gs/messaging-reactor/
 * 
 * 
 * 
 * @author root
 *
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {

    private static final int NUMBER_OF_QUOTES = 10;

    @Bean
    Environment env() {
        return Environment.initializeIfEmpty()
                          .assignErrorJournal();
    }

    @Bean
    EventBus createEventBus(Environment env) {
	    return EventBus.create(env, Environment.THREAD_POOL);
    }

	@Autowired
	private EventBus eventBus;

	@Autowired
	private Receiver receiver;

	@Autowired
	private Publisher publisher;

	@Bean
	public CountDownLatch latch() {
		return new CountDownLatch(NUMBER_OF_QUOTES);
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext app = SpringApplication.run(Application.class, args);

		app.getBean(CountDownLatch.class).await(1, TimeUnit.SECONDS);

		app.getBean(Environment.class).shutdown();
	}

	public void run(String... args) throws Exception {
		eventBus.on($("quotes"), receiver);
		publisher.publishQuotes(NUMBER_OF_QUOTES);
		
	}

}
