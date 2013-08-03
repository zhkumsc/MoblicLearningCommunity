package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.CoursesFollow;

/**
 * 课程关注DAO接口
 * @author jc
 *
 */
public interface CoursesFollowDAO {
	public boolean add(CoursesFollow coursesfollow);
	public boolean delete(int id);
	public boolean update(CoursesFollow coursesfollow);
	public CoursesFollow findById(int id);
	public CoursesFollow findById(int coursesId,int userId);
	public List<CoursesFollow> findByUserId(int userId);
	public List<CoursesFollow> findBycoursesId(int coursesId);
	public List<CoursesFollow> listAll();
}
