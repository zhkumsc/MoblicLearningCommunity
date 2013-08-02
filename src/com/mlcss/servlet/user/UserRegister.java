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

@SuppressWarnings("serial")
public class UserRegister extends HttpServlet {
	
	private UserDAO userDAO = new UserDAOImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 处理注册请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String userJsonString = request.getParameter("json");
System.out.println(userJsonString);
		JSONObject o;
		o = JSONObject.fromObject(userJsonString);
		User u = (User)JSONObject.toBean(o, User.class);
		resgiter(response, u);	
	}

	private void resgiter(HttpServletResponse response, User user) throws IOException {
		
		PrintWriter out = response.getWriter();		
		if(!invalid(user)) {
			response.setStatus(400);
			out.print("提交表单带有问题");
			System.out.println("提交表单带有问题");
			return;
		} 
		
		if(userDAO.findByEmail(user.getEmail()) != null) {
System.out.println(user.getEmail());
			response.setStatus(400);
			out.print("该用户已经存在");
			System.out.println("该用户已经存在");
			return;
		}
		if(!userDAO.add(user)) {	// 注册
			response.setStatus(500);
			out.print("服务器内部问题");
			System.out.println("服务器内部问题");
			return;
		} 
		
		out.print("注册成功");
	}

	/**
	 * 验证user时候合法
	 * @param user
	 * @return
	 */
	private boolean invalid(User user) {
		if(user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
			return false;
		}
		if(user.getName().trim().equals("") || user.getPassword().trim().equals("") || user.getEmail().trim().equals("")) {
			return false;
		}
		// 邮箱验证
		if(!user.getEmail().matches("\\w+@\\w+(\\.\\w+)+")) {
			return false;
		}
		return true;
	}

}
