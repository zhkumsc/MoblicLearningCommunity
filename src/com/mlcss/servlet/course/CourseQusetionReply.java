package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.QuestionAsk;
import com.mlcss.bean.QuestionReply;
import com.mlcss.dao.impl.QuestionReplyDAOImpl;
import com.mlcss.dao.impl.QuestionAskDAOImpl;

public class CourseQusetionReply extends HttpServlet {
     private  QuestionReplyDAOImpl que=new QuestionReplyDAOImpl();
	@Override
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
	    JSONObject  qr;
	    qr =JSONObject.fromObject(questionjson);
	   QuestionReply   questionr=(QuestionReply) JSONObject.toBean(qr,QuestionReply.class);
	   System.out.println(questionr.getId()+questionr.getQuestionid()+questionr.getContent()+questionr.getCreatetime());
	   
	   if(!que.add(questionr)){
		   resp.setStatus(500);
		   out.print("服务器出错");
		   System.out.println("服务器出错");
		   return;
		   
	   }
	   out.println("添加成功");
	   System.out.println("成功");
	   }
	}


