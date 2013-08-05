package com.mlcss.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.mlcss.bean.SystemMessages;
import com.mlcss.bean.UserChatrecords;
import com.mlcss.dao.SystemMessagesDAO;
import com.mlcss.dao.impl.SystemMessagesDAOImpl;

public class MessageGetSystem extends HttpServlet {

	SystemMessagesDAO smd = new SystemMessagesDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 获得系统消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		String jsonString = null;
//		int userId = (Integer)request.getSession().getAttribute("userId");
int userId = 1; // 测试
		boolean state = request.getParameter("state").equals("0") ? false : true;
		
		List<SystemMessages> list = smd.getAllMessageByReceiverId(userId, state);
		if(list != null) {
			jsonString = JSONArray.fromObject(list).toString();
			smd.setListReceived(list);
		}
		
		out.print(jsonString);
		out.close();
System.out.println(jsonString);
	}

}
