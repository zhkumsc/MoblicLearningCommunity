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

public class CourseQuestionAsk extends HttpServlet {
     private  QuestionAskDAOImpl que=new QuestionAskDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String questionjson=req.getParameter("json");
	    PrintWriter  out=resp.getWriter();
	    System.out.print(questionjson);
	    JSONObject  q;
	    q =JSONObject.fromObject(questionjson);
	   QuestionAsk   question=(QuestionAsk) JSONObject.toBean(q,QuestionAsk.class);
	   System.out.println(question.getId()+question.getCoursesid()+question.getTitle());
	   if(question.getTitle()==""){
		   resp.setStatus(400);
			out.print("提交数据错误");
			System.out.println("提交数据错误");
			return;
		   
	   }
	   if(!que.add(question)){
		   resp.setStatus(500);
		   out.print("服务器出错");
		   System.out.println("服务器出错");
		   return;
		   
	   }
	   out.print("成功");
	   }
	}


