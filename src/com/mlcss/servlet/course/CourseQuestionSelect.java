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
import com.mlcss.bean.UserNotes;
import com.mlcss.dao.impl.QuestionAskDAOImpl;


public class CourseQuestionSelect extends HttpServlet {
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
	   if (ques.getId() != 0) {
			QuestionAsk q = cpl.findById(ques.getId());
			if (q != null) {
				String anote = JSONObject.fromObject(q).toString();
				out.print(anote);
				return;
			} else {
				resp.setStatus(400);
				out.print("对不起，找不到数据");
				System.out.println("对不起，找不到数据");
				return;
			}

		}
		else if (ques.getCoursesid() != 0) {
			List<QuestionAsk> questionlist= new ArrayList<QuestionAsk>();
			questionlist = cpl.findall((ques.getCoursesid()));
			if (questionlist != null) {
				String q = JSONArray.fromObject(questionlist).toString();
				for(QuestionAsk qq:questionlist)
				out.print(qq);
				return;
			} else {
				resp.setStatus(400);
				out.print("找不到数据");
				System.out.println("找不到数据");
				return;
			}
	   }
	
	}}


