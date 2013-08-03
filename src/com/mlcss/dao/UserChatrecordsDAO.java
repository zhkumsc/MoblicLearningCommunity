package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.UserChatrecords;


public interface UserChatrecordsDAO {
	public boolean add(UserChatrecords chatrecords);
	public boolean delete(int userid);
	public boolean isread(UserChatrecords chatrecords);
	public List<UserChatrecords> findById(int userid,int friendid);

}
