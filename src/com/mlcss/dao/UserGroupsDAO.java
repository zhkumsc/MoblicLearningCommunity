package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.UserGroups;



public interface UserGroupsDAO {
	public boolean add(UserGroups user);
	public boolean delete(int id);
	public boolean update(UserGroups user);
	public List<UserGroups> listAll(int userId);
	public UserGroups findById(int id);
	public UserGroups findFriendGroups(int userId,String groupName);
}
