package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.CoursesSchedule;
import com.mlcss.dao.CoursesScheduleDAO;
import com.mlcss.dao.impl.CoursesScheduleDAOImpl;
/**
 * @author jc
 */
public class UserScheduleAdd extends HttpServlet {

	CoursesScheduleDAO courseScheduleDAO = new CoursesScheduleDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 *用户添加课程表记录 客户端传json转化为CoursesSchedule对象
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String json = request.getParameter("json");
		CoursesSchedule coursesSchedule = (CoursesSchedule) JSONObject.toBean(JSONObject.fromObject(json), CoursesSchedule.class);
		if(coursesSchedule==null || !courseScheduleDAO.add(coursesSchedule)){
			response.setStatus(400);
			out.println("课程表记录添加失败！");
		}else{
//			out.println("课程表记录添加成功！");
			out.println(coursesSchedule);
		}
		out.flush();
		out.close();
	}

}
