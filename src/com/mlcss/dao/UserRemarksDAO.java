package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.UserRemarks;

public interface UserRemarksDAO {
	public boolean add(UserRemarks ur);
	public boolean delete(Serializable id);
	public boolean update(UserRemarks ur);
	public UserRemarks findById(int id);
	public UserRemarks findByTitle(String title);
	public List<UserRemarks> listAll();
}
