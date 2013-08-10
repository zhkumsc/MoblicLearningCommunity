package com.mlcss.dao.impl;

import java.util.List;

import org.junit.Test;

import com.mlcss.bean.CoursesUserInfo;
import com.mlcss.dao.CoursesUserInfoDAO;


public class TestCoursesUserInfoDAOImpl {

	CoursesUserInfoDAO cuinfoDAO = new CoursesUserInfoDAOImpl();
	
	@Test
	public void testAdd(){
		CoursesUserInfo cuinfo = new CoursesUserInfo();
		cuinfo.setCoursesId(2);
		cuinfo.setUserId(8);
		cuinfo.setRemark("亮哥");
		cuinfo.setRole("教师");
		cuinfoDAO.add(cuinfo);
	}
	
	@Test
	public void testUpdate(){
		CoursesUserInfo cuinfo = new CoursesUserInfo();
		cuinfo.setCoursesId(1);
		cuinfo.setUserId(10);
		
		cuinfo.setRemark("波哥");
		cuinfo.setRole("老师");
		cuinfoDAO.update(cuinfo);
	}
	
	@Test
	public void testDel(){
		cuinfoDAO.delete(2);
	}
	
	@Test
	public void testFindbyId(){
		CoursesUserInfo cuinfo = new CoursesUserInfo();
		cuinfo = cuinfoDAO.findById(3);
		System.out.println("id="+cuinfo.getId());
		System.out.println("CoursesId="+cuinfo.getCoursesId());
		System.out.println("Userid="+cuinfo.getUserId());
		System.out.println("remark="+cuinfo.getRemark());
		System.out.println("role="+cuinfo.getRole());
	}
	
	@Test
	public void testFindBycoursesId(){
		List list =cuinfoDAO.findBycoursesId(1);
		for(int i=0;i<list.size();i++){
			CoursesUserInfo cuinfo = (CoursesUserInfo) list.get(i);
			System.out.println("id="+cuinfo.getId()+";CoursesId="+cuinfo.getCoursesId()+";Userid="+cuinfo.getUserId() +
					";remark="+cuinfo.getRemark()+";role="+cuinfo.getRole());
		}
	}
	
	@Test
	public void testlistAll(){
		List list =cuinfoDAO.listAll();
		for(int i=0;i<list.size();i++){
			CoursesUserInfo cuinfo = (CoursesUserInfo) list.get(i);
			System.out.println("id="+cuinfo.getId()+";CoursesId="+cuinfo.getCoursesId()+";Userid="+cuinfo.getUserId() +
					";remark="+cuinfo.getRemark()+";role="+cuinfo.getRole());
		}
	}
}
