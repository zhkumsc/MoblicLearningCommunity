package com.mlcss.bean;

import java.sql.Timestamp;

public class CoursesNotice {
	private int id;
	private int coursesId;
	private String noticeTitle;
	private String content;
	private String noticeTime;
	private int userId;
	private boolean isReceived ;
	

	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(int coursesId) {
		this.coursesId = coursesId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CoursesNotice [id=" + id + ", coursesId=" + coursesId
				+ ", noticeTitle=" + noticeTitle + ", content=" + content
				+ ", noticeTime=" + noticeTime + ", userId=" + userId
				+ ", isReceived=" + isReceived + "]";
	}
	
	
}
