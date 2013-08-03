package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.CoursesNotice;

public interface CoursesNoticeDAO {
	public boolean add(CoursesNotice cn);
	public boolean delete(Serializable id);
	public boolean update(CoursesNotice cn);
	public CoursesNotice findById(int id);
	public CoursesNotice findByTitle(String title);
	public List<CoursesNotice> listAll();
}
