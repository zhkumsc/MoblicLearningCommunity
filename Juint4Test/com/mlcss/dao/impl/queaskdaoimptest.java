package com.mlcss.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.mlcss.bean.Courses;
import com.mlcss.bean.QuestionAsk;
public class queaskdaoimptest {
	
			
     @Test  
	public void  testadd(){
    	 QuestionAsk q=new QuestionAsk();
    	 QuestionAskDAOImpl qd=new QuestionAskDAOImpl();
		q.setCoursesid(6);
		q.setTitle("aa");
		q.setCreateby(8);
		
		
	boolean	a=qd.add(q);
	if(a){
		System.out.println("插入数据成功");
	}
	else{System.out.println("插入不成功");} 
		
	}
	@Test
	public void testupdat(){
		QuestionAsk q=new QuestionAsk();
   	 QuestionAskDAOImpl qd=new QuestionAskDAOImpl();
		q.setCoursesid(6);
		q.setContent("bb");
		q.setId(1);
		q.setCreateby(8);
		q.setTitle("abc");
		boolean b=qd.update(q);
		if(b){
		System.out.println("修改成功");
		}else{
				System.out.println("失败");}
	}
	@Test
	public void testdell(){
		QuestionAsk q=new QuestionAsk();
	   	 QuestionAskDAOImpl qd=new QuestionAskDAOImpl();
		boolean f=qd.delById(8);
		if(f){
			System.out.println("删除成功");
		}else{System.out.println("删除失败");}
	}
	@Test
	public void testfid(){
		QuestionAsk q=new QuestionAsk();
	   	 QuestionAskDAOImpl qd=new QuestionAskDAOImpl();
	   	QuestionAsk w=qd.findById(2);
		System.out.println(w.getTitle());
	}
	@Test
	public void testall(){
		List<QuestionAsk>c=new ArrayList<QuestionAsk>();
		QuestionAskDAOImpl qd=new QuestionAskDAOImpl();
		c=qd.findall(6);
		for(QuestionAsk f:c){
			System.out.println(f.getTitle());
			System.out.println(f.getId());
		}
	}
}
