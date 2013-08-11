package com.mlcss.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.mlcss.bean.Courses;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
public class CoursDaoImplTest {
	Courses c=new Courses();
	CoursesDAOImpl cd=new CoursesDAOImpl();
     @Test  
	public void  testadd(){
		Courses c=new Courses();
		CoursesDAOImpl cd=new CoursesDAOImpl();
		c.setName("体育");
		c.setClassshuours(21);
		c.setCreateby(8);
		
	boolean	a=cd.add(c);
	if(a){
		System.out.println("插入数据成功");
	}
	else{System.out.println("插入不成功");} 
		
	}
	@Test
	public void testupdat(){
		Courses d=new Courses();
		CoursesDAOImpl cf=new CoursesDAOImpl();
		d.setName("英语");
		d.setId(6);
		d.setCreateby(8);
		d.setClassshuours(20);
		d.setDescription("fff");
		boolean b=cf.update(d);
		if(b){
		System.out.println("修改成功");
		}else{
				System.out.println("失败");}
	}
	@Test
	public void testdell(){
		CoursesDAOImpl cdel=new CoursesDAOImpl();
		boolean f=cdel.delById(5);
		if(f){
			System.out.println("删除成功");
		}else{System.out.println("删除失败");}
	}
	@Test
	public void testfid(){
		CoursesDAOImpl f=new CoursesDAOImpl();
		Courses ca=f.findById(6);
		System.out.println(ca.getName());
	}
	@Test
	public void testall(){
		List<Courses>c=new ArrayList<Courses>();
		CoursesDAOImpl cp=new CoursesDAOImpl();
		c=cp.findAll();
		for(Courses f:c){
			System.out.println(f.getName());
		}
	}
}
