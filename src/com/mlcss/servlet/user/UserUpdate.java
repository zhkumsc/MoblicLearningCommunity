package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.User;
import com.mlcss.dao.UserDAO;
import com.mlcss.dao.impl.UserDAOImpl;
/*
 * 修改用户name 密码 头像
 */
@SuppressWarnings("serial")
public class UserUpdate extends HttpServlet {

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
		User u1 = (User)JSONObject.toBean(o, User.class);
		
		UserDAO dao = new UserDAOImpl();
		User u2 = dao.findById(u1.getId());
		System.out.println(u2);
		if(u1.getName()!=null){
			u2.setName(u1.getName());
		}
		if(u1.getPassword()!=null){
			u2.setName(u1.getPassword());
		}
		if(u1.getUserIcon()!=null){
			u2.setUserIcon(u1.getUserIcon());
		}
		if(u1.getQq()!=0){
			u2.setQq(u1.getQq());
		}
		if(u1.getSchool()!=null){
			u2.setSchool(u1.getSchool());
		}
		if(u1.getSignature()!=null){
			u2.setSignature(u1.getSignature());
		}
		
		if(dao.update(u2)){
			out.print("修改成功");
		}else{
			out.print("修改失败");
		}
	}

}
