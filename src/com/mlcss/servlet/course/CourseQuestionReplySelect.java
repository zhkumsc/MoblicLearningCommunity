package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlcss.bean.QuestionAsk;
import com.mlcss.bean.QuestionReply;
import com.mlcss.bean.UserNotes;
import com.mlcss.dao.impl.QuestionAskDAOImpl;
import com.mlcss.dao.impl.QuestionReplyDAOImpl;


public class CourseQuestionReplySelect extends HttpServlet {
     private  QuestionReplyDAOImpl cpl=new QuestionReplyDAOImpl();
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
	   QuestionReply ques=(QuestionReply) JSONObject.toBean(c,QuestionReply.class);
	   if (ques.getId() != 0) {
			QuestionReply q = cpl.findById(ques.getId());
			if (q != null) {
				String qe = JSONObject.fromObject(q).toString();
				out.print(qe);
				return;
			} else {
				resp.setStatus(400);
				out.print("对不起，找不到数据");
				System.out.println("对不起，找不到数据");
				return;
			}

		}
		else if (ques.getQuestionid()!= 0) {
			List<QuestionReply> questionlist= new ArrayList<QuestionReply>();
			questionlist = cpl.findAll((ques.getQuestionid()));
			if (questionlist != null) {
				String q = JSONArray.fromObject(questionlist).toString();
				for(QuestionReply qq:questionlist)
				out.print(questionlist);
				return;
			} else {
				resp.setStatus(400);
				out.print("找不到数据");
				System.out.println("找不到数据");
				return;
			}
	   }
	
	}}


