package com.mlcss.servlet.user;

import java.io.IOException;

/**
 * 登陆Servlet
 */
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mlcss.bean.User;
import com.mlcss.dao.UserDAO;
import com.mlcss.dao.impl.UserDAOImpl;
import com.mlcss.util.ServiceUtil;

public class UserLogin extends HttpServlet {
	
	private UserDAO userDAO = new UserDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 处理登陆请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
System.out.println("email:" + email + "\n" + "password:" + password);

		if(logByEmail(email, password)) {
			session.setAttribute("logState", "1");
		} else {
			session.setAttribute("logState", "0");
			response.setStatus(400);
			out.print("登录失败");
			System.out.println("登录失败");
		}
	}


	/**
	 * 验证登陆
	 * @param email 登陆email
	 * @param password	登陆密码
	 * @return
	 */
	private boolean logByEmail(String email, String password) {
		User user = userDAO.findByEmail(email);
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
		
		
	}

}
