package com.springboot.domain;

/**
 * @author Administrator
 *
 *	用户
 */
public class Users {
	
	private Integer id;
	private String username;
	private String passowrd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
