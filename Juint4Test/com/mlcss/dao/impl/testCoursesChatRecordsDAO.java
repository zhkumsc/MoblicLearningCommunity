package com.mlcss.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.dao.CoursesChatRecordsDAO;
import com.mlcss.dao.impl.CoursesChatRecordsDAOImpl;
import com.mlcss.util.DateTimeUtil;

public class testCoursesChatRecordsDAO {

	@Test
	public void testAddChatRecord() {
		CoursesChatRecordsDAO ccrd  = new CoursesChatRecordsDAOImpl();
		CoursesChatRecords ccr = new CoursesChatRecords();
		ccr.setCoursesId(1);
		ccr.setUserId(1);
		ccr.setContent("abc");
		ccr.setCreateTime(DateTimeUtil.date2String(new Timestamp(System.currentTimeMillis())));
		ccr.setReceived(false);
		ccrd.addChatRecord(ccr);

	}
	
	@Test
	public void testUpdateChatRecord() {
		CoursesChatRecordsDAO ccrd  = new CoursesChatRecordsDAOImpl();
		CoursesChatRecords ccr = new CoursesChatRecords();
		ccr.setId(1);
		ccr.setCoursesId(1);
		ccr.setUserId(2);
		ccr.setContent("ddd");
		ccr.setCreateTime(DateTimeUtil.date2String(new Timestamp(System.currentTimeMillis())));
		ccr.setReceived(true);
		ccrd.updateChatRecord(ccr);
		
	}
	
	@Test
	public void testDelChatRecordById() {
		int id = 2;
		CoursesChatRecordsDAO ccrd  = new CoursesChatRecordsDAOImpl();
		ccrd.delChatRecordById(id);
	}
	
	@Test
	public void testDelAllChatRecord() {
		int id = 1;
		CoursesChatRecordsDAO ccrd  = new CoursesChatRecordsDAOImpl();
		ccrd.delAllChatRecordByCourseId(id);
	}
	
	@Test
	public void testGetAllCoursesChatRecords() {
		CoursesChatRecordsDAO ccrd  = new CoursesChatRecordsDAOImpl();
		List<CoursesChatRecords> list = ccrd.getAllCoursesChatRecords(1);
		for(CoursesChatRecords c : list) {
			System.out.println(c.toString());
		}
	}
	
	@Test
	public void testGetCoursesChatRecordsById() {
		CoursesChatRecordsDAO ccrd  = new CoursesChatRecordsDAOImpl();
		System.out.println(ccrd.getCoursesChatRecordsById(9).toString());
	}
	

}
