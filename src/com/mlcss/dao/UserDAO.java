package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.User;

public interface UserDAO {
	public boolean add(User user);
	public boolean delete(Serializable bean);
	public boolean update(User user);
	public Serializable findById(int id);
	public List<Serializable> findByName(String name);
	public List<Serializable> listAll();
}
