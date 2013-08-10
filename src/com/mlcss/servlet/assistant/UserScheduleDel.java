package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlcss.dao.CoursesScheduleDAO;
import com.mlcss.dao.impl.CoursesScheduleDAOImpl;
/**
 * @author jc
 */
public class UserScheduleDel extends HttpServlet {

	CoursesScheduleDAO courseScheduleDAO = new CoursesScheduleDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	/**
	 * 用户课程表删除 客户端传id过来
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int scheduleId = Integer.parseInt(request.getParameter("id"));
		if (!courseScheduleDAO.delete(scheduleId)) {
			response.setStatus(400);
			out.println("课程表记录删除失败！");
		} else {
			out.println("课程表记录删除成功！");
		}
		out.flush();
		out.close();
	}

}
