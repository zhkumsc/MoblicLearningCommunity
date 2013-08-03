package com.mlcss.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class UserChatrecords {
	private int id;
	private int userid;
	private int friendid;
	private String content;
	private String createtime;
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
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public boolean isIsrceived() {
		return isrceived;
	}
	public void setIsrceived(boolean isrceived) {
		this.isrceived = isrceived;
	}
	private boolean isrceived;
	@Override
	public String toString() {
		return "UserChatrecords [id=" + id + ", userid=" + userid
				+ ", friendid=" + friendid + ", content=" + content
				+ ", createtime=" + createtime + ", isrceived=" + isrceived
				+ "]";
	}

}
