package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.QuestionReply;
import com.mlcss.dao.impl.QuestionReplyDAOImpl;


public class CourseQuestionReplyDel extends HttpServlet {
     private  QuestionReplyDAOImpl quepl=new QuestionReplyDAOImpl();
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
	   QuestionReply  ques=(QuestionReply) JSONObject.toBean(c,QuestionReply.class);
	   	 
	   	  // 用id或者用Questionid来删除一条记录
	   if(quepl.delAllQuesttions(ques.getQuestionid())||quepl.delById(ques.getId())){
		   
		   out.println("删除成功");
		   
	   }
	   else
	   {
	  resp.setStatus(500);
	   out.print("服务器出错");
	   System.out.println("服务器出错");
	   return;
	   
	   }
	  
		   
	   
	   }
	
	}


