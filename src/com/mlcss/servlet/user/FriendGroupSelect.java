package com.mlcss.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserGroups;
import com.mlcss.dao.impl.UserGroupsDAOImpl;
/*
 * 查找好友分组
 */
@SuppressWarnings("serial")
public class FriendGroupSelect extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserGroupsDAOImpl ugdi = new UserGroupsDAOImpl();
		List<UserGroups> list = ugdi.listAll();
	   
		if(list==null){
			System.out.println("dddd");
		}
		for(UserGroups ug:list){
			JSONObject jsonUser = JSONObject.fromObject(ug);	    	
			System.out.println(jsonUser.toString());
		}
	}

}
