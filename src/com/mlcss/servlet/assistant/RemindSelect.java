package com.mlcss.servlet.assistant;

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

import com.mlcss.bean.RemindUser;
import com.mlcss.bean.UserNotes;
import com.mlcss.dao.RemindUserDAO;
import com.mlcss.dao.impl.RemindUserDAOImpl;

public class RemindSelect extends HttpServlet {
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
		RemindUser k=	reminduserdao.getRemindById(remind.getId());
		if (k != null) {
			String aremind = JSONObject.fromObject(k).toString();
			out.print(aremind);
			return;
		} else {
			response.setStatus(400);
			out.print("找不到提醒");
			System.out.println("找不到提醒");
			return;
		}

	}
	else if (remind.getReceiverId() != 0) {
		List<RemindUser> remindslist = new ArrayList<RemindUser>();
		remindslist = reminduserdao.getAllRemindByReceiverId(remind.getReceiverId());
		if (remindslist != null) {
			String reminds = JSONArray.fromObject(remindslist).toString();
			out.print(reminds);
			return;
		} else {
			response.setStatus(400);
			out.print("找不到提醒");
			System.out.println("找不到提醒");
			return;
		}
	}

		
	}

}
