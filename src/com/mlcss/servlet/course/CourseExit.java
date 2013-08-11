package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.CoursesFollow;
import com.mlcss.dao.CoursesFollowDAO;
import com.mlcss.dao.impl.CoursesFollowDAOImpl;
/**
 * @author jc
 */
public class CourseExit extends HttpServlet {
	
	private CoursesFollowDAO coursesFollowDAO = new CoursesFollowDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 用户取消课程关注
	 * 接受客户端传递过来的ID
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int coursesFollowId = Integer.parseInt(request.getParameter("id"));
		if(!coursesFollowDAO.delete(coursesFollowId)) {
			response.setStatus(400);
			out.println("取消关注课程失败！");
		}else
			out.println("取消关注课程成功");
		out.flush();
		out.close();
	}

}
