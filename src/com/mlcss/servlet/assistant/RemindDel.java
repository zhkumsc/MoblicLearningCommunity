package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.RemindUser;
import com.mlcss.dao.RemindUserDAO;
import com.mlcss.dao.impl.RemindUserDAOImpl;

public class RemindDel extends HttpServlet {
	RemindUserDAO reminduserdao = new RemindUserDAOImpl();

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
		RemindUser remind = (RemindUser) JSONObject.toBean(o, RemindUser.class);
		if (remind.getId() != 0) {
			if (!reminduserdao.delRemindById(remind.getId())) {
				response.setStatus(400);
				out.print("找不到提醒");
				System.out.println("找不到提醒");
				return;

			}

		}
		else if(remind.getReceiverId()!=0){
			if (!reminduserdao.delAllRemindReceiverId(remind.getReceiverId())) {
				response.setStatus(400);
				out.print("找不到提醒");
				System.out.println("找不到提醒");
				return;
			
		}
		

		}
		out.print("删除提示成功！");
	}

}
