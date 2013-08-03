package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.UserGroups;



public interface UserGroupsDAO {
	public boolean add(UserGroups user);
	public boolean delete(int id);
	public boolean update(UserGroups user);
	public UserGroups findById(int id);
	
	

}
