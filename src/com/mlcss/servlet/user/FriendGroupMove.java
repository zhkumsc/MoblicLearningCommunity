package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserRelShip;
import com.mlcss.dao.impl.UserGroupsDAOImpl;
import com.mlcss.dao.impl.UserRelShipDAOImpl;
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
		
		PrintWriter out = response.getWriter();
		
		String userJson = request.getParameter("json");
		System.out.println(userJson);
		JSONObject o = JSONObject.fromObject(userJson);
		UserRelShip urs = (UserRelShip)JSONObject.toBean(o, UserRelShip.class);
		
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		UserGroupsDAOImpl ugdi = new UserGroupsDAOImpl();
		
		//判断要移动到的分组是否存在
		if(ugdi.findById(urs.getGroupId())==null){
			out.print("该分组不存在，移动失败！");
			System.out.println("该分组不存在！");
			return;
		}
		
		if(ursdi.friendGroupMove(urs)){
			out.print("移动好友成功！");
		}else{
		    out.print("移动好友失败！");	
		}
		out.close();
	}

	public void init() throws ServletException {
	}

}
