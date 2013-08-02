package com.mlcss.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class UserNotes {
	private int id;
	private int userid;
	private String title;
	private String content;
	private Timestamp creattime;
	private boolean isshared;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreattime() {
		return creattime;
	}
	public void setCreattime(Timestamp creattime) {
		this.creattime = creattime;
	}
	public boolean isIsshared() {
		return isshared;
	}
	public void setIsshared(boolean isshared) {
		this.isshared = isshared;
	}
	

}
