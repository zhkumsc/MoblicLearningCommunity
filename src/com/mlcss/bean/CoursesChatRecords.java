package com.mlcss.bean;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 课程聊天记录
 * 
 * @author Administrator
 * 
 */
public class CoursesChatRecords implements Serializable {
	/* 列名
	 * CREATE TABLE `courseschatrecords` ( 
	 * `id` int(11) NOT NULL AUTO_INCREMENT,
	 * `coursesId` int(11) DEFAULT NULL, 
	 * `userId` int(11) DEFAULT NULL,
	 * `content` varchar(120) DEFAULT NULL, 
	 * `createTime` datetime DEFAULT NULL,
	 * `isReceived` bit(1) DEFAULT b'0', 
	 * PRIMARY KEY (`id`), 
	 * KEY `idx_cosChatReco_coursesID` (`coursesId`) USING BTREE, 
	 * KEY idx_cosChatReco_userId` (`userId`) USING BTREE, 
	 * CONSTRAINT `fk_cosChatReco_coursesID` FOREIGN KEY (`coursesId`) REFERENCES `courses`
	 * (`id`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT
	 * `fk_cosChatReco_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
	 * ON DELETE CASCADE ON UPDATE CASCADE )
	 */
	
	private int id;
	private int coursesId;
	private int userId;
	private String content;
	private Timestamp createTime;
	private boolean isReceived;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	public int getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(int coursesId) {
		this.coursesId = coursesId;
	}
	@Override
	public String toString() {
		return "CoursesChatRecords [id=" + id + ", courseId=" + coursesId
				+ ", userId=" + userId + ", content=" + content
				+ ", createTime=" + createTime + ", isReceived=" + isReceived
				+ "]";
	}
	
	
	

}
