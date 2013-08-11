package com.mlcss.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.mlcss.bean.Courses;
import com.mlcss.bean.QuestionAsk;
import com.mlcss.bean.QuestionReply;
public class queaplydaoimptest {
	
			
     @Test  
	public void  testadd(){
    	 QuestionReply qr=new QuestionReply();
    	 QuestionReplyDAOImpl qrp=new QuestionReplyDAOImpl(); 
		qr.setContent("aa");
		qr.setQuestionid(2);
		qr.setUserid(8);
		
		
	boolean	a=qrp.add(qr);
	if(a){
		System.out.println("插入数据成功");
	}
	else{System.out.println("插入不成功");} 
		
	}
	@Test
	public void testupdat(){
		 QuestionReply qr=new QuestionReply();
    	 QuestionReplyDAOImpl qrp=new QuestionReplyDAOImpl(); 
		qr.setContent("ff");
		qr.setId(1);
		qr.setUserid(8);
	   qr.setQuestionid(2);
		boolean b=qrp.update(qr);
		if(b){
		System.out.println("修改成功");
		}else{
				System.out.println("失败");}
	}
	@Test
	public void testdell(){
		QuestionReply qr=new QuestionReply();
   	 QuestionReplyDAOImpl qrp=new QuestionReplyDAOImpl();
		boolean f=qrp.delById(1);
		if(f){
			System.out.println("删除成功");
		}else{System.out.println("删除失败");}
	}
	@Test
	public void testfid(){
		QuestionReply qr=new QuestionReply();
   	 QuestionReplyDAOImpl qrp=new QuestionReplyDAOImpl();
	   	QuestionReply w=qrp.findById(2);
		System.out.println(w.getContent());
	}
	@Test
	public void testall(){
		List<QuestionReply>c=new ArrayList<QuestionReply>();
		QuestionReplyDAOImpl qd=new QuestionReplyDAOImpl();
		c=qd.findAll(2);
		for(QuestionReply f:c){
			System.out.println(f.getContent());
			System.out.println(f.getId());
		}
	}
}
