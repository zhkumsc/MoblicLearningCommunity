package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.Courses;
import com.mlcss.dao.CoursesDAO;
import com.mlcss.dao.impl.CoursesDAOImpl;
/**
 * @author jc
 */
public class CourseDel extends HttpServlet {

	private CoursesDAO coursesDAO = new CoursesDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 用户删除课程
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int coursesId = Integer.parseInt(request.getParameter("id"));
		if(!coursesDAO.delById(coursesId)) {
			response.setStatus(400);
			out.println("删除课程失败！");
		}else
			out.println("删除课程成功");
		out.flush();
		out.close();
	}

}
