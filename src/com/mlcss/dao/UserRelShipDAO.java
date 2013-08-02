package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.UserRelShip;

public interface UserRelShipDAO {
	public boolean add(UserRelShip urs);
	public boolean delete(Serializable id);
	public boolean update(UserRelShip urs);
	public UserRelShip findById(int id);
	public List<UserRelShip> listAll();
}
