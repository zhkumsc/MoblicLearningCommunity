package com.mlcss.bean;

import java.sql.Timestamp;

/**
 * 课程课表 bean
 * @author jc
 *
 */
public class CoursesSchedule {

	private int id;
	private int userId;
	private int coursesId;
	private String coursesTime;
	private String coursesPlace;
	private byte isUsed;
	private int teatherId;
	
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
	public int getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(int coursesId) {
		this.coursesId = coursesId;
	}
	public String getCoursesPlace() {
		return coursesPlace;
	}
	public void setCoursesPlace(String coursesPlace) {
		this.coursesPlace = coursesPlace;
	}
	public byte getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(byte isUsed) {
		this.isUsed = isUsed;
	}
	public int getTeatherId() {
		return teatherId;
	}
	public void setTeatherId(int teatherId) {
		this.teatherId = teatherId;
	}
	public String getCoursesTime() {
		return coursesTime;
	}
	public void setCoursesTime(String coursesTime) {
		this.coursesTime = coursesTime;
	}
	
	
	
	
}
