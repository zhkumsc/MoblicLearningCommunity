package com.mlcss.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.Courses;
import com.mlcss.bean.CoursesNotice;
import com.mlcss.dao.CoursesDAO;
import com.mlcss.dao.CoursesNoticeDAO;
import com.mlcss.dao.impl.CoursesDAOImpl;
import com.mlcss.dao.impl.CoursesNoticeDAOImpl;
import com.mlcss.util.DateTimeUtil;

public class MessageSendCourseNotice extends HttpServlet {

	CoursesNoticeDAO cnd = new CoursesNoticeDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	/**
	 * 发送课程通知
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String json = request.getParameter("json");
System.out.println(json);
		CoursesNotice cn = (CoursesNotice)JSONObject.toBean(JSONObject.fromObject(json), CoursesNotice.class);
		//int userId = (Integer)request.getSession().getAttribute("userId");
int userId = 1; //测试
		if(cn != null && isCreator(userId, cn) && cnd.addTOAll(cn)) {
			out.close();
			return;
		}
		response.setStatus(400);
		out.write("表单错误，用户无权发通知");
		out.close();
	}


	/**
	 * 验证用户是否课程的创建者
	 * @param userId	用户ID
	 * @param cn	课程
	 * @return
	 */
	private boolean isCreator(int userId, CoursesNotice cn) {
		CoursesDAO cd = new CoursesDAOImpl();
		Courses course = cd.findById(cn.getCoursesId());
		if(course.getCreateby().equals(String.valueOf(userId))) {
			cn.setNoticeTime(DateTimeUtil.date2String(new Date()));
			cn.setUserId(userId);
			cn.setReceived(false);
			return true;
		}
		return false;
	}

}
