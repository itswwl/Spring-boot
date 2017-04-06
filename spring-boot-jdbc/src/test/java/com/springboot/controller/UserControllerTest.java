package com.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.springboot.Application;

/**
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
public class UserControllerTest {

	private RestTemplate template = new TestRestTemplate();

	@Test
	public void setupMockMvc() {
		String url = "http://localhost:8080/index";
		String result = template.postForObject(url, null, String.class);
		System.out.println("===============" + result);
	}

}
