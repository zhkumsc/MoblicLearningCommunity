package com.mlcss.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Courses {
	private int id;
	private String name;
	private Timestamp createTime;
	private int createby ;
	private int classshuours ;
    private String description ;
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
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime( Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getCreateby() {
		return createby;
	}
	public void setCreateby(int createby) {
		this.createby = createby;
	}
	public int getClassshuours() {
		return classshuours;
	}
	public void setClassshuours(int classshuours) {
		this.classshuours = classshuours;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", createTime="
				+ createTime + ", createby=" + createby + ", classshuours="
				+ classshuours + ", description=" + description + "]";
	}
}
