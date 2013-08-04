package com.mlcss.dao;

import java.sql.SQLException;
import java.util.List;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.bean.CoursesFollow;

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
	
	/**
	 * 返回某User所有的记录
	 * @param userId 	用户id
	 * @param received	false为取出未读消息，true为取出所有id
	 * @return
	 */
	public abstract List<CoursesChatRecords> getAllCoursesChatRecordsByUserId(
			int userId, boolean received);
	
	/**
	 * 设置指定信息为已读
	 * @param id
	 * @return
	 */
	public abstract boolean setReceivedById(int id);

	
	/**
	 * 批量设置已读
	 * @param list
	 */
	public abstract boolean setListReceived(List<CoursesChatRecords> list);

	/**
	 * 发送到所有人
	 * @param newCcr 
	 * @param list
	 * @return
	 */
	public abstract boolean addChatRecordToAll(CoursesChatRecords newCcr, List<CoursesFollow> list);

}