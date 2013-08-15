package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.QuestionAsk;
import com.mlcss.dao.impl.QuestionAskDAOImpl;


public class CourseQuestionDel extends HttpServlet {
     private  QuestionAskDAOImpl cpl=new QuestionAskDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String que=req.getParameter("json");
	    PrintWriter  out=resp.getWriter();
	    System.out.print(que);
	    JSONObject c;
	    c =JSONObject.fromObject(que);
	   QuestionAsk  ques=(QuestionAsk) JSONObject.toBean(c,QuestionAsk.class);
	   	   
	   if(!cpl.delAllQuesttions(ques.getCoursesid())){
		   resp.setStatus(500);
		   out.print("出错");
		   System.out.println("出错");
		   return;
		   
	   }else{
	   out.print("删除成功");
	   }
	   }
	
	}


