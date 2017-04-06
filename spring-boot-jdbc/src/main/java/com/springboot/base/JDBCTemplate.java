package com.springboot.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplate {
	@Autowired
	public JdbcTemplate jdbcTemplate;

}
