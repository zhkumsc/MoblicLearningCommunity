package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.CoursesUserInfo;

/**
 * 课程用户信息DAO接口
 * @author jc
 *
 */
public interface CoursesUserInfoDAO {
	public boolean add(CoursesUserInfo coursesuserinfo);
	public boolean delete(int id);
	public boolean update(CoursesUserInfo coursesuserinfo);
	public CoursesUserInfo findById(int id);
	public CoursesUserInfo findById(int coursesId,int userId);
	public List<CoursesUserInfo> findByUserId(int userId);
	public List<CoursesUserInfo> findBycoursesId(int coursesId);
	public List<CoursesUserInfo> listAll();
}
