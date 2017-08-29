package com.yohomall.pojo;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.yohomall.util.Util;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String email;
	private String password;
	private String sex;
	private Date	birthday;
	private String uname;
	
	private String nickname;
	
	private List<Orders> orders;
	
	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public void setPassword(String password) {
		
		this.password = password;
	}



	public String getPassword() {
		
		return password;
	}



	public List<Orders> getOrders() {
		return orders;
	}



	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
