package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserNotes;
import com.mlcss.dao.UserNotesDAO;
import com.mlcss.dao.impl.UserNotesDAOImpl;

public class NoteDel extends HttpServlet {
	private UserNotesDAO usernotesDAO=new UserNotesDAOImpl();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();		
		String notejsonString=request.getParameter("json");
		System.out.println(notejsonString);
		JSONObject o;
		o = JSONObject.fromObject(notejsonString);
		UserNotes note=(UserNotes)JSONObject.toBean(o,UserNotes.class);
		if(note.getId()==0){
			response.setStatus(400);
			out.print("提交表单带有问题");
			System.out.println("提交表单带有问题");
			return;
		}
		if(!usernotesDAO.delete(note.getId())){
			response.setStatus(500);
			out.print("服务器内部问题");
			System.out.println("服务器内部问题");
			return;
		}
		out.print("删除笔记成功！");
		
		

		
	}
	
}
