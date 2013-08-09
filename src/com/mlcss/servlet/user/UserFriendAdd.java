package com.mlcss.servlet.user;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserRelShip;
import com.mlcss.dao.impl.UserRelShipDAOImpl;
/*
 * 增加好友
 */
@SuppressWarnings("serial")
public class UserFriendAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userJson = request.getParameter("json");
		System.out.println(userJson);
		JSONObject o = JSONObject.fromObject(userJson);
		UserRelShip urs = (UserRelShip)JSONObject.toBean(o, UserRelShip.class);
		urs.setCreateTime(new Timestamp(System.currentTimeMillis()));
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		if(ursdi.add(urs)){
			System.out.println("添加好友成功！");
		}else{
			System.out.println("添加好友失败！");
		}
	}

}
