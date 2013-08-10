package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.UserRelShip;

public interface UserRelShipDAO {
	public boolean add(UserRelShip urs);
	public boolean delete(int userId,int friendId);
	public boolean update(UserRelShip urs);
	public UserRelShip findById(int id);
	public UserRelShip findByUserIdAndFriendId(int userId,int friendId);
	public List<UserRelShip> listAll(int userId);
}
