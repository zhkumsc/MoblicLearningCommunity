package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlcss.bean.CoursesSchedule;
import com.mlcss.dao.CoursesScheduleDAO;
import com.mlcss.dao.impl.CoursesScheduleDAOImpl;

/**
 * @author jc
 */
public class GetUserSchedules extends HttpServlet {

	CoursesScheduleDAO courseScheduleDAO = new CoursesScheduleDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 *获得用户 课程表  客户端传json转化为CoursesSchedule List类型的对象
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		List list = courseScheduleDAO.findByUserId(id);
		if(list != null){
			String toJson = JSONArray.fromObject(list).toString();
			out.println(toJson);
//			out.println("课程表记录添加成功！");
		}else{
			response.setStatus(400);
			out.println("课程表记录添加失败！");
		}
		out.flush();
		out.close();
	}

}
