package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.User;

public interface UserDAO {
	public boolean add(User user);
	public boolean delete(Serializable bean);
	public boolean update(User user);
	public User findById(int id);
	public User findByEmail(String email);
	public List<User> findByName(String name);
	public List<User> listAll();
}
