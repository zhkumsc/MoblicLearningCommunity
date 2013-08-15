package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.dao.impl.UserRelShipDAOImpl;
/*
 * 删除好友
 */
@SuppressWarnings("serial")
public class UserFriendDel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userJson = request.getParameter("json");
		System.out.println(userJson);
		JSONObject jo = JSONObject.fromObject(userJson);
		int userId = jo.getInt("userId");
		int friendId = jo.getInt("friendId");
		
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		if(ursdi.delete(userId,friendId)){
			ursdi.delete(friendId, userId);
			out.print("删除好友成功！");
		}else{
			out.print("删除好友失败！");
		}
		out.close();
	}

}
