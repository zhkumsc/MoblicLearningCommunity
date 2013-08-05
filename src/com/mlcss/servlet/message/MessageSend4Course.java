package com.mlcss.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.Courses;
import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.bean.CoursesFollow;
import com.mlcss.dao.CoursesChatRecordsDAO;
import com.mlcss.dao.CoursesFollowDAO;
import com.mlcss.dao.impl.CoursesChatRecordsDAOImpl;
import com.mlcss.dao.impl.CoursesFollowDAOImpl;
import com.mlcss.util.DateTimeUtil;

public class MessageSend4Course extends HttpServlet {

	private CoursesChatRecordsDAO ccrd = new CoursesChatRecordsDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 发送消息处理请求处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String json = request.getParameter("json");
		CoursesChatRecords newCcr = (CoursesChatRecords)JSONObject.toBean(JSONObject.fromObject(json), CoursesChatRecords.class);
	
		if(!checkAndProcess(newCcr) || !ccrd.addChatRecordToAll(newCcr)) {
			response.setStatus(400);
			out.println("表单数据错误发送失败！");
		} 
		
		out.close();
		
	}



	/**
	 * 验证数据是否有效，并处理数据
	 * @param newCcr	准备加入数据库的数据
	 * @return
	 */
	private boolean checkAndProcess(CoursesChatRecords newCcr) {
		if(newCcr == null)
			return false;
		
		newCcr.setCreateTime(DateTimeUtil.date2String(new Timestamp(System.currentTimeMillis())));
		newCcr.setReceived(false);
		return true;
		
	}

}
