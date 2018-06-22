package com.jiang.springbootserverstarter.beans;

/**
 * 表user_credit于此程序中对应的domain object。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
public class UserCredit {
	
	private Integer id;
	private String userName;
	private Integer credit;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
