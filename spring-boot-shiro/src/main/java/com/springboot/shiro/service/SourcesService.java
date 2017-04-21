package com.springboot.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.shiro.dao.SourceDao;

@Service
public class SourcesService {

	@Autowired
	private SourceDao sourceDao;
	
}
