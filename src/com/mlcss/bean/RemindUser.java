package com.mlcss.bean;

import java.sql.Timestamp;


/**
 * 用户提醒
 * 
 * @author fantasy
 * 
 */
public class RemindUser {
	/*
	 * CREATE TABLE `reminduser` ( 
	 * `id` int(11) NOT NULL AUTO_INCREMENT,
	 * `receiverId` int(11) DEFAULT NULL, 
	 * `createTime` datetime DEFAULT NULL,
	 * `content` varchar(120) DEFAULT NULL, 
	 * `identifying` bit(1) DEFAULT NULL,
	 * `isReceived` bit(1) DEFAULT b'0', 
	 * PRIMARY KEY (`id`), 
	 * KEY `idx_uRemind_userId` (`receiverId`) USING BTREE, 
	 * CONSTRAINT `fk_uRemind_userId` FOREIGN KEY (`receiverId`) REFERENCES `users` (`id`)
	 * ON DELETE CASCADE ON UPDATE CASCADE )
	 */
	
	private int id;
	private int receiverId;
	private String content;
	private Timestamp createTime;
	private byte identifying;		// 备忘提醒为1，课程提醒为0
	private byte isReceived;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
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
	public byte getIdentifying() {
		return identifying;
	}
	public void setIdentifying(byte identifying) {
		this.identifying = identifying;
	}

	public byte getIsReceived() {
		return isReceived;
	}
	public void setIsReceived(byte isReceived) {
		this.isReceived = isReceived;
	}
	@Override
	public String toString() {
		return "RemindUser [id=" + id + ", receiverId=" + receiverId
				+ ", content=" + content + ", createTime=" + createTime
				+ ", identifying=" + identifying + ", isRecevied=" + isReceived
				+ "]";
	}
	
	
}
