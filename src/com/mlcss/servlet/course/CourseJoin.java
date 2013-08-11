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
public class CourseJoin extends HttpServlet {

	private CoursesFollowDAO coursesFollowDAO = new CoursesFollowDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 用户关注某一课程
	 * 接收客户端传过来的CoursesFollow对象
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String json  =  request.getParameter("json");
		CoursesFollow coursesFollow = (CoursesFollow) JSONObject.toBean(JSONObject.fromObject(json), CoursesFollow.class);
		if(coursesFollow == null || !coursesFollowDAO.add(coursesFollow)){
			response.setStatus(400); 
			System.out.println("加入课程失败！");
		}else{
			out.println(coursesFollow);
		}
		out.flush();
		out.close();
	}

}
