package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserGroups;
import com.mlcss.dao.impl.UserGroupsDAOImpl;
/*
 * 增加好友分组
 */
@SuppressWarnings("serial")
public class FriendGroupAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String userJson = request.getParameter("json");
		System.out.println(userJson);
		
		//从json中取出数据
		JSONObject jb = JSONObject.fromObject(userJson);
		int userId = jb.getInt("id");
		String groupName = jb.getString("groupname");
		
		//将传过来的数据添加进UserGroups
		UserGroups ug = new UserGroups();
		ug.setUserid(userId);
		ug.setGroupname(groupName);
		
		//判断该分组是否存在
		UserGroupsDAOImpl ugdi = new UserGroupsDAOImpl();
		if(ugdi.findFriendGroups(userId,groupName)!=null){
			out.print("该分组已经存在！");
			System.out.println("该分组已经存在！");
			return;
		}
		
		//添加分组
		if(ugdi.add(ug)){
			out.print("添加好友分组成功！");
		}else{
			out.print("添加好友分组s失败！");		
		}
		out.close();
	}

}
