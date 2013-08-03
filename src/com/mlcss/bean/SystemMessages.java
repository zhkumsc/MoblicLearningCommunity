package com.mlcss.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 系统信息记录表
 * 
 * @author Administrator
 * 
 */
public class SystemMessages implements Serializable {
	/*
	 * CREATE TABLE `systemmessages` ( 
	 * `id` int(11) NOT NULL AUTO_INCREMENT,
	 * `receiverId` int(11) DEFAULT NULL, 
	 * `content` varchar(120) DEFAULT NULL,
	 * `createTime` datetime DEFAULT NULL, 
	 * `isReceived` bit(1) DEFAULT b'0',
	 * PRIMARY KEY (`id`), 
	 * KEY `idx_sysMsg_receiverId` (`receiverId`) USING
	 * BTREE, CONSTRAINT `fk_sysMsg_receiverId` FOREIGN KEY (`receiverId`)
	 * REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE )
	 */
	
	private int id;
	private int receiverId;
	private String content;
	private Timestamp createTime;
	private boolean isReceived;
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
	
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	@Override
	public String toString() {
		return "SystemMessages [id=" + id + ", receiverId=" + receiverId
				+ ", content=" + content + ", createTime=" + createTime
				+ ", isReceived=" + isReceived + "]";
	}
	
	
}
