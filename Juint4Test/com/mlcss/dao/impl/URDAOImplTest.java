package com.mlcss.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.UserRemarks;

public class URDAOImplTest {
	
	UserRemarks ur = new UserRemarks();
	UserRemarksDAOImpl urdi = new UserRemarksDAOImpl();
	
	@Test
	public void testAdd(){
		Date d = new Date();     
		ur.setUserId(10);
		ur.setTitle("java作业");
		ur.setContent("java第二次试验结束时间快到了，明天记得要做完哦！");
		ur.setCreateTime(d);
		Calendar c = Calendar.getInstance();
		c.set(2013, 9, 1);    //可以对每个时间域单独修改
		ur.setRemindTime(c.getTime());
		/*int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1; //java中month的范围是从0--11，所以，你去出的Calendar.MONTH+1才是我们要用的月份。
		int date = c.get(Calendar.DATE);
		System.out.println(year + "/" + month + "/" + date);*/
		
		urdi.add(ur);
	}
	
	@Test
	public void testDelete(){
		urdi.delete(1);
	}
	
	@Test
	public void testUpdate(){
		ur.setId(2);
		ur.setTitle("考试");
		ur.setContent("考试时间为星期三下午2点半到4点半");
		Calendar c = Calendar.getInstance();
		c.set(2013, 9, 5);    //可以对每个时间域单独修改
		ur.setRemindTime(c.getTime());
		urdi.update(ur);
	}
	
	@Test
	public void testFindById(){
		ur = urdi.findById(2);
		if(ur==null){
			System.out.println("该备忘不存在！");
		}else{
			System.out.println("id="+ur.getId()+" userId="+ur.getUserId()+" Title="+ur.getTitle()+" content="+ur.getContent()+" createTime="+ur.getCreateTime()+" remindTime="+ur.getRemindTime());
		}
	}
	
	@Test
	public void testFindByTitle(){
		ur = urdi.findByTitle("考试");
		if(ur==null){
			System.out.println("不存在该通知！");
		}else{
			System.out.println("id="+ur.getId()+" userId="+ur.getUserId()+" Title="+ur.getTitle()+" content="+ur.getContent()+" createTime="+ur.getCreateTime()+" remindTime="+ur.getRemindTime());
		}	
	}
	
	@Test
	public void testListAll(){
		List<UserRemarks> list = urdi.listAll();
		for(int i=0;i<list.size();i++){
			ur = list.get(i);
			System.out.println("id="+ur.getId()+" userId="+ur.getUserId()+" Title="+ur.getTitle()+" content="+ur.getContent()+" createTime="+ur.getCreateTime()+" remindTime="+ur.getRemindTime());
		}
	}
}
