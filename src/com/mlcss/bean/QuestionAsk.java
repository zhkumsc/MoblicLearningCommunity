package com.mlcss.bean;

import java.sql.Timestamp;

public class QuestionAsk {
	private  int id;
	private  int coursesid;
	private  String title;
	private  String content;
	private String createby;
	private Timestamp createtime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoursesid() {
		return coursesid;
	}
	public void setCoursesid(int coursesid) {
		this.coursesid = coursesid;
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
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public Timestamp getCreatetime() {
		return  createtime;
	}
	public void setCreatetime( Timestamp  createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "QuestionAsk [id=" + id + ", coursesid=" + coursesid
				+ ", title=" + title + ", content=" + content + ", createby="
				+ createby + ", createtime=" + createtime + "]";
	}

}
