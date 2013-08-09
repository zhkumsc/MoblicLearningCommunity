package com.mlcss.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserGroups;
import com.mlcss.dao.impl.UserGroupsDAOImpl;
/**
 * 将好友移动到好友分组
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class FriendGroupMove extends HttpServlet {

	public FriendGroupMove() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

	}

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
		if(ugdi.friendGroupMove(ug)){
			System.out.println("移动好友成功！");
		}else{
		    System.out.println("移动好友失败！");	
		}
	}

	public void init() throws ServletException {
	}

}
