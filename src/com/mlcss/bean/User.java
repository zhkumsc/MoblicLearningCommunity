package com.mlcss.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable{

	private int id;
	private String name;
	private String password;
	private String email;
	private String userIcon;
	private Date createTime;
	private long qq;
	private String school;
	private String signature;
	
	



	public long getQq() {
		return qq;
	}




	public void setQq(long qq) {
		this.qq = qq;
	}




	public String getSchool() {
		return school;
	}




	public void setSchool(String school) {
		this.school = school;
	}




	public String getSignature() {
		return signature;
	}




	public void setSignature(String signature) {
		this.signature = signature;
	}




	public String getUserIcon() {
		return userIcon;
	}




	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}




	public Date getCreateTime() {
		return createTime;
	}




	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}


	

	public User(String name, String password, String email, String userIcon) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.userIcon = userIcon;
		
	}




	public User() {
	}


	// 调试用
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", email=" + email + "]";
	}
	
	
	

}
