package com.mlcss.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.CoursesFollow;
import com.mlcss.bean.User;
import com.mlcss.dao.CoursesFollowDAO;

public class TestCoursesFollowDAOImpl {

	CoursesFollowDAO cfDAO = new CoursesFollowDAOImpl();
	
	@Test
	public void testAdd(){
		CoursesFollow cf = new CoursesFollow();
		cf.setCoursesId(2);
		cf.setUserId(8);
		cfDAO.add(cf);
	}
	
	@Test
	public void testUpdate(){
		CoursesFollow cf = new CoursesFollow();
		cf.setCoursesId(1);
		cf.setUserId(9);
		cfDAO.update(cf);
	}
	
	@Test
	public void testDel(){
		cfDAO.delete(2);
	}
	
	@Test
	public void testFindbyId(){
		CoursesFollow cf = new CoursesFollow();
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cf = cfDAO.findById(1);
		System.out.println("id="+cf.getId());
		System.out.println("CoursesId="+cf.getCoursesId());
		System.out.println("Userid="+cf.getUserId());
//		System.out.println("CreateTime="+sf.format(cf.getCreateTime()));
		System.out.println("CreateTime="+cf.getCreateTime());
	}
	
	@Test
	public void testFindby2Id(){
		CoursesFollow cf = new CoursesFollow();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cf = cfDAO.findById(1,8);
		System.out.println("id="+cf.getId());
		System.out.println("CoursesId="+cf.getCoursesId());
		System.out.println("Userid="+cf.getUserId());
		System.out.println("CreateTime="+sf.format(cf.getCreateTime()));
	}
	
	@Test
	public void testFindByUserId(){
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List list =cfDAO.findByUserId(8);
		for(int i=0;i<list.size();i++){
			CoursesFollow cf = (CoursesFollow) list.get(i);
			System.out.println("id="+cf.getId()+";CoursesId="+cf.getCoursesId()+";Userid="+cf.getUserId()+";CreateTime="+cf.getCreateTime());
		}
	}
	
	@Test
	public void testFindBycoursesId(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List list =cfDAO.findBycoursesId(1);
		for(int i=0;i<list.size();i++){
			CoursesFollow cf = (CoursesFollow) list.get(i);
			System.out.println("id="+cf.getId()+";CoursesId="+cf.getCoursesId()+";Userid="+cf.getUserId()+";CreateTime="+cf.getCreateTime());
		}
	}
	
	@Test
	public void testlistAll(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List list =cfDAO.listAll();
		for(int i=0;i<list.size();i++){
			CoursesFollow cf = (CoursesFollow) list.get(i);
			System.out.println("id="+cf.getId()+";CoursesId="+cf.getCoursesId()+";Userid="+cf.getUserId()+";CreateTime="+cf.getCreateTime());
		}
	}
}
