package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserRelShip;
import com.mlcss.dao.impl.UserRelShipDAOImpl;
/**
 * json格式： String JsonString = "{\"userId\":10, \"friendId\":9, \"friendNote\":\"msm\"}";
 * 修改好友备注
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class FriendRename extends HttpServlet {

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
		
		if(urs.getFriendNote()==null){
			out.print("好友备注不能为空！");
		}
		
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		if(ursdi.friendRename(urs)){
			out.print("好友备注修改成功！");
		}else{
			out.print("好友备注修改失败！");
		}
		out.close();
	}

}
