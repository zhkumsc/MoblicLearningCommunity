package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.CoursesSchedule;

/**
 * 课程课表DAO接口
 * @author jc
 *
 */
public interface CoursesScheduleDAO {

	public boolean add(CoursesSchedule coursesschedule);
	public boolean delete(int id);
	public boolean update(CoursesSchedule coursesschedule);
	public CoursesSchedule findById(int id);
	public CoursesSchedule findById(int coursesId,int userId);
	public List<CoursesSchedule> findByUserId(int userId);
	public List<CoursesSchedule> listAll();
}
