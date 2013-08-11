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
public class CourseSelect extends HttpServlet {

	private CoursesDAO coursesDAO = new CoursesDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 对于某一课程的搜索，获取该课程的信息 
	 * 接收客户端传过来的id
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int coursesid = Integer.parseInt(request.getParameter("id"));
		Courses selected = coursesDAO.findById(coursesid);
		
		String JSONselected = JSONObject.fromObject(selected).toString();
		
		if(selected==null) {
			response.setStatus(400);
			out.println("查找课程失败！");
		}else{
			out.println("查找课程成功");
			System.out.println(JSONselected);
		}
		out.flush();
		out.close();
	}

}
