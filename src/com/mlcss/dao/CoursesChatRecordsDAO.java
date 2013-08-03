package com.mlcss.dao;

import java.sql.SQLException;
import java.util.List;

import com.mlcss.bean.CoursesChatRecords;

public interface CoursesChatRecordsDAO {

	/**
	 * 增加记录
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public abstract boolean addChatRecord(CoursesChatRecords record);

	/**
	 * 删除某条记录
	 * @param id
	 * @return
	 */
	public abstract boolean delChatRecordById(int id);

	/**
	 * 删除某课程所有记录
	 * @param courseId
	 * @return
	 */
	public abstract boolean delAllChatRecordByCourseId(int coursesId);

	/**
	 * 更新某条记录
	 * @param Record
	 * @return
	 */
	public abstract boolean updateChatRecord(CoursesChatRecords record);

	/**
	 * 返回某课程所有记录
	 * @param courseId
	 * @return
	 */
	public abstract List<CoursesChatRecords> getAllCoursesChatRecords(
			int coursesId);

	/**
	 * 返回某条记录
	 * @param id
	 * @return
	 */
	public abstract CoursesChatRecords getCoursesChatRecordsById(int id);

}