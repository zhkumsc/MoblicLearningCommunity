package com.mlcss.bean;

import java.util.Date;

public class UserRemarks {
	private int id;
	private int userId;
	private String title;
	private String content;
	private Date createTime;
	private Date RemindTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getRemindTime() {
		return RemindTime;
	}
	public void setRemindTime(Date remindTime) {
		RemindTime = remindTime;
	}
}
