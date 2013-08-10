package com.mlcss.bean;

import java.sql.Timestamp;

public class UserRelShip {
	private int id;
	private int userId;
	private int friendId;
	private int groupId;
	private Timestamp createTime;
	private String friendNote;
	public UserRelShip(int userId, int friendId, int groupId,
			Timestamp createTime, String friendNote) {
		super();
		this.userId = userId;
		this.friendId = friendId;
		this.groupId = groupId;
		this.createTime = createTime;
		this.friendNote = friendNote;
	}
	public String getFriendNote() {
		return friendNote;
	}
	public void setFriendNote(String friendNote) {
		this.friendNote = friendNote;
	}
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
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public UserRelShip() {
		super();
		// TODO Auto-generated constructor stub
	}
}
