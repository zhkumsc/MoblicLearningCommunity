package com.mlcss.servlet.user;

import java.io.IOException;

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
		String userJson = request.getParameter("json");
		System.out.println(userJson);
		JSONObject o = JSONObject.fromObject(userJson);
		User u = (User)JSONObject.toBean(o, User.class);
		
		if(u.getName()==null){
			System.out.println("用户名不能为空！");
		}
		if(u.getPassword()==null){
			System.out.println("密码不能为空！");
		}
		
		UserDAO dao = new UserDAOImpl();
		if(dao.update(u)){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}

}
