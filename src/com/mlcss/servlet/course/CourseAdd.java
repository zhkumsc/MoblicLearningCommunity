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
public class CourseAdd extends HttpServlet {

	private CoursesDAO coursesDAO = new CoursesDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 用户创建课程 json转化为Courses对象进行数据库操作
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String coursesjson = request.getParameter("json");
		Courses courses = (Courses) JSONObject.toBean(JSONObject.fromObject(coursesjson), Courses.class);
		if(courses==null || !coursesDAO.add(courses)) {
			response.setStatus(400);
			out.println("表单数据错误创建失败！");
		}else
			out.println("创建课程成功");
		out.flush();
		out.close();
	}

}
