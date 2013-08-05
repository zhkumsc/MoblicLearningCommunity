package com.mlcss.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.dao.CoursesChatRecordsDAO;
import com.mlcss.dao.impl.CoursesChatRecordsDAOImpl;

public class MessageGet4Course extends HttpServlet {

	private CoursesChatRecordsDAO ccrd = new CoursesChatRecordsDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 接受消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String jsonString = null;
		//int userId = (Integer)request.getSession().getAttribute("userId");
int userId = 1; // 测试
		boolean state = request.getParameter("state").equals("0") ? false : true;
		List<CoursesChatRecords> list = ccrd.getAllCoursesChatRecordsByUserId(userId, state);
		if(list != null) {
			jsonString = JSONArray.fromObject(list).toString();
			ccrd.setListReceived(list);
		}
		
		out.print(jsonString);
		out.close();
System.out.println(jsonString);
		
	}

}
