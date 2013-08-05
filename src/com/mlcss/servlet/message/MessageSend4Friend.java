package com.mlcss.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserChatrecords;
import com.mlcss.dao.UserChatrecordsDAO;
import com.mlcss.dao.impl.UserChatrecordsDAOImpl;
import com.mlcss.util.DateTimeUtil;

public class MessageSend4Friend extends HttpServlet {
	
	private UserChatrecordsDAO uccd = new UserChatrecordsDAOImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	/**
	 * 用户发送私聊
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String json = request.getParameter("json");
System.out.println(json);
		UserChatrecords ucr = (UserChatrecords)JSONObject.toBean(JSONObject.fromObject(json), UserChatrecords.class);
		if(!checkAndProcess(ucr) || !uccd.add(ucr)) {
			response.setStatus(400);
			out.println("表单数据错误发送失败！");

		}
		
		out.close();
	}


	private boolean checkAndProcess(UserChatrecords ucr) {
		if(ucr == null)
			return false;
		
		ucr.setIsrceived(false);
		ucr.setCreatetime(DateTimeUtil.date2String(new Date()));
		return true;
	}

}
