package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.User;
import com.mlcss.dao.impl.UserDAOImpl;

@SuppressWarnings("serial")
public class UserSelectById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAOImpl udi = new UserDAOImpl();
		User user = udi.findById(id);
		if(user!=null){
			JSONObject jo = JSONObject.fromObject(user);
			System.out.println(jo.toString());
			out.print(jo);
		}else{
			System.out.println("该用户不存在");
			out.print("用户不存在");
		}
	}

}
