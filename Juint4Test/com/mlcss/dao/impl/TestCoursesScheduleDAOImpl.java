package com.mlcss.dao.impl;

import java.util.List;

import org.junit.Test;

import com.mlcss.bean.CoursesSchedule;
import com.mlcss.dao.CoursesScheduleDAO;;

public class TestCoursesScheduleDAOImpl {

	CoursesScheduleDAO csDAO = new CoursesScheduleDAOImpl();
	
	@Test
	public void testAdd(){
		CoursesSchedule cs = new CoursesSchedule();
		cs.setCoursesId(1);
		cs.setUserId(8);
		cs.setCoursesTime("2013-8-2 17:58:11");
		cs.setCoursesPlace("教学楼110");
		cs.setIsUsed((byte) 0);
		cs.setTeatherId(9);
		csDAO.add(cs);
	}
	
	@Test
	public void testUpdate(){
		CoursesSchedule cs = new CoursesSchedule();
		cs.setCoursesId(2);
		cs.setUserId(8);
		
		cs.setCoursesTime("2013-8-2 17:58:11");
		cs.setCoursesPlace("教学楼550");
		cs.setIsUsed((byte) 0);
		cs.setTeatherId(8);
		csDAO.update(cs);
	}
	
	@Test
	public void testDel(){
		csDAO.delete(2);
	}
	
	@Test
	public void testFindbyId(){
		CoursesSchedule cs = new CoursesSchedule();
		cs = csDAO.findById(1);
		System.out.println("id="+cs.getId());
		System.out.println("CoursesId="+cs.getCoursesId());
		System.out.println("Userid="+cs.getUserId());
		System.out.println("CoursesTime="+cs.getCoursesTime());
		System.out.println("CoursesPlace="+cs.getCoursesPlace());
		System.out.println("IsUsed="+cs.getIsUsed());
		System.out.println("TeatherId="+cs.getTeatherId());
	}
	
	@Test
	public void testFindby2Id(){
		CoursesSchedule cs = new CoursesSchedule();
		cs = csDAO.findById(2,8);
		System.out.println("id="+cs.getId());
		System.out.println("CoursesId="+cs.getCoursesId());
		System.out.println("Userid="+cs.getUserId());
		System.out.println("CoursesTime="+cs.getCoursesTime());
		System.out.println("CoursesPlace="+cs.getCoursesPlace());
		System.out.println("IsUsed="+cs.getIsUsed());
		System.out.println("TeatherId="+cs.getTeatherId());
	}
	
	@Test
	public void testFindByUserId(){
		List list =csDAO.findByUserId(8);
		for(int i=0;i<list.size();i++){
			CoursesSchedule cs = (CoursesSchedule) list.get(i);
			System.out.println("id="+cs.getId()+";CoursesId="+cs.getCoursesId()+";Userid="+cs.getUserId() +
					";CoursesTime="+cs.getCoursesTime()+";CoursesPlace="+cs.getCoursesPlace()+";IsUsed="+cs.getIsUsed()+";TeatherId="+cs.getTeatherId());
		}
	}
	
	
	@Test
	public void testlistAll(){
		List list =csDAO.listAll();
		for(int i=0;i<list.size();i++){
			CoursesSchedule cs = (CoursesSchedule) list.get(i);
			System.out.println("id="+cs.getId()+";CoursesId="+cs.getCoursesId()+";Userid="+cs.getUserId() +
					";CoursesTime="+cs.getCoursesTime()+";CoursesPlace="+cs.getCoursesPlace()+";IsUsed="+cs.getIsUsed()+";TeatherId="+cs.getTeatherId());
		}
	}
}
