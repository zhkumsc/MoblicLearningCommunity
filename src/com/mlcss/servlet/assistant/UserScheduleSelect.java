package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlcss.dao.CoursesScheduleDAO;
import com.mlcss.dao.impl.CoursesScheduleDAOImpl;
/**
 * @author jc
 */
public class UserScheduleSelect extends HttpServlet {

	CoursesScheduleDAO courseScheduleDAO = new CoursesScheduleDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 查询单个用户的所有课程表项
	 * 客户端传用户的id过来
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int userId = Integer.parseInt(request.getParameter("id"));
		
		List list = new ArrayList();
		list = courseScheduleDAO.findByUserId(userId);
		if(list==null){
			response.setStatus(400);
			out.println("课程表记录查询失败！");
		}else if(list.size()==0){
			out.println("课程表记录为0！");
		}else{
//			System.out.println("课程表记录查询成功！");
			String liststring = JSONArray.fromObject(list).toString();
			out.println(liststring);
		}
		out.flush();
		out.close();
	}

}
