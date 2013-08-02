package com.mlcss.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.CoursesNotice;

public class CNDAOImplTest {
	CoursesNoticeDAOImpl cndi = new CoursesNoticeDAOImpl();
	CoursesNotice cn = new CoursesNotice();
	
	@Test
	public void testAdd(){		
		cn.setCoursesId(1);
		cn.setNoticeTitle("基金第三方");
		cn.setContent("明天的课推迟到后天!");
		cn.setNoticeTime(new Timestamp(System.currentTimeMillis()));
		cn.setUserId(10);
		
		cndi.add(cn);
	}
	
	@Test
	public void testDelete(){
		cndi.delete(2);
	}
	
	@Test
	public void testUpdate(){
		cn.setId(3);
		cn.setNoticeTitle("调课");
		cn.setContent("明天上午的课取消，调整到下周四上午");
		cndi.update(cn);
	}
	
	@Test
	public void testFindById(){
		cn = cndi.findById(2);
		if(cn==null){
			System.out.println("该通知不存在！");
		}else{
			System.out.println("id="+cn.getId()+" coursesId="+cn.getCoursesId()+" noticeTitle="+cn.getNoticeTitle()+" content="+cn.getContent()+" noticeTime="+cn.getNoticeTime()+" userId="+cn.getUserId());
		}
	}
	
	@Test
	public void testFindByTitle(){
		cn = cndi.findByTitle("调课");
		if(cn==null){
			System.out.println("不存在该通知！");
		}else{
			System.out.println("id="+cn.getId()+" coursesId="+cn.getCoursesId()+" noticeTitle="+cn.getNoticeTitle()+" content="+cn.getContent()+" noticeTime="+cn.getNoticeTime()+" userId="+cn.getUserId());
		}	
	}
	
	@Test
	public void testListAll(){
		List<CoursesNotice> list = cndi.listAll();
		for(int i=0;i<list.size();i++){
			cn = list.get(i);
			System.out.println("id="+cn.getId()+" coursesId="+cn.getCoursesId()+" noticeTitle="+cn.getNoticeTitle()+" content="+cn.getContent()+" noticeTime="+cn.getNoticeTime()+" userId="+cn.getUserId());
		}
	}
}
