package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.RemindUser;
import com.mlcss.bean.UserNotes;
import com.mlcss.dao.RemindUserDAO;
import com.mlcss.dao.impl.RemindUserDAOImpl;

public class RemindAdd extends HttpServlet {
	RemindUserDAO reminduserdao=new RemindUserDAOImpl();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String remindjsonString = request.getParameter("json");
		System.out.println(remindjsonString);
		JSONObject o;
		o = JSONObject.fromObject(remindjsonString);
		RemindUser remind = (RemindUser) JSONObject.toBean(o,RemindUser.class);
		if (!invalid(remind)) {
			response.setStatus(400);
			out.print("提交表单带有问题");
			System.out.println("提交表单带有问题");
			return;
		}
		if(!reminduserdao.addRemind(remind)){
			response.setStatus(500);
			out.print("服务器内部问题");
			System.out.println("服务器内部问题");
			return;
		}
		out.print("添加提醒成功！");
		

		
	}
	private boolean invalid(RemindUser remind) {
		if (remind.getContent()==null||remind.getReceiverId()==0) {
			return false;
		}
		if (remind.getContent().trim().equals("")) {
			return false;
		}
//		if(remind.getIdentifying()!=(byte) 1||remind.getIdentifying()!=(byte) 0){
//			return false;
//		}
		return true;

	}

}
