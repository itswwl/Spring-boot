package com.kafka.controller;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController2 {

	@Autowired
	private Producer<String, String> producer;

	@Autowired
	private Consumer<String, String> consumer;

	@RequestMapping(value = "/send2", method = RequestMethod.GET)
	public String send2() {
		producer.send(new ProducerRecord<String, String>("send2", "send2",
				"≤‚ ‘send2"));
		return "success";
	}

	@RequestMapping(value = "/revice2", method = RequestMethod.GET)
	public void revice2() {
		consumer.subscribe(Arrays.asList("send2"));

		ConsumerRecords<String, String> records = consumer.poll(100);
		System.out.println("====================" + records.count());
		for (ConsumerRecord<String, String> record : records) {
			System.out.printf("offset=%s, key=%s, value=%s", record.offset(),
					record.key(), record.value());
		}

	}

}
