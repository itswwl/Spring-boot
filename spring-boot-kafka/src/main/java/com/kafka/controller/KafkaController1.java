package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaController1 {
	
	@RequestMapping(value = "/test",method=RequestMethod.GET)
	public String test(){
		return "test";
	}
	
	
	@Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send1", method = RequestMethod.GET)
    public String sendKafka() {
        try {
            String message = "发送消息";
            kafkaTemplate.send("send1", "key", message);
            return "success";
        } catch (Exception e) {
            return "异常";
        }
    }

}
