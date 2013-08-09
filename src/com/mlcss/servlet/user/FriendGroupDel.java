package com.mlcss.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserGroups;
import com.mlcss.dao.impl.UserGroupsDAOImpl;
/*
 * 删除好友分组
 */
@SuppressWarnings("serial")
public class FriendGroupDel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userJson = request.getParameter("json");
		System.out.println(userJson);
		JSONObject o = JSONObject.fromObject(userJson);
		UserGroups ug = (UserGroups)JSONObject.toBean(o, UserGroups.class);
		
		UserGroupsDAOImpl ugdi = new UserGroupsDAOImpl();
		if(ugdi.delete(ug.getId())){
			System.out.println("删除好友分组成功！");
		}else{
			System.out.println("删除好友分组失败！");
		}
		
	}

}
