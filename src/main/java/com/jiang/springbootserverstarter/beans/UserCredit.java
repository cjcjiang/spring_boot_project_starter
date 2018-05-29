package com.jiang.springbootserverstarter.beans;

public class UserCredit {
	
	private Integer id;
	private String userName;
	private Integer credit;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}

}
