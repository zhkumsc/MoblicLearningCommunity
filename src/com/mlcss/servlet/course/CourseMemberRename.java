package com.mlcss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.CoursesUserInfo;
import com.mlcss.dao.CoursesDAO;
import com.mlcss.dao.CoursesUserInfoDAO;
import com.mlcss.dao.impl.CoursesDAOImpl;
import com.mlcss.dao.impl.CoursesUserInfoDAOImpl;
/**
 * @author jc
 */
public class CourseMemberRename extends HttpServlet {

	private CoursesUserInfoDAO coursesUserInfoDAO = new CoursesUserInfoDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 修改某一个用户在某一个课程里面的备注名称
	 * 
	 * coursesUserInfo对象传过来前记得把之前该用户在 课程用户信息表 的 信息 填入改对象，以免信息被空值覆盖。
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String json = request.getParameter("json");
		CoursesUserInfo coursesUserInfo = (CoursesUserInfo) JSONObject.toBean(JSONObject.fromObject(json), CoursesUserInfo.class);
		
		CoursesUserInfo isExistInfo = coursesUserInfoDAO.findById(coursesUserInfo.getCoursesId(), coursesUserInfo.getUserId());
		
		//更新有两种情况
		//第一：用户备注或角色 没有存在在数据库，就需要创建一条记录。
		//第二：用户备注或角色  已经存在数据库了，就直接更新记录。
			
		//用户备注或角色没有记录
		if(isExistInfo == null){
			//创建记录
			if(coursesUserInfoDAO.add(coursesUserInfo)){
				out.println(coursesUserInfo );
			}else{
				//输出错误
				response.setStatus(400);
				out.println("修改用户备注失败！");
			}
		}else{//用户备注或角色有记录
			  //更新记录
			if(coursesUserInfoDAO.update(coursesUserInfo)){
				out.println(coursesUserInfo );
			}else{
				//输出错误
				response.setStatus(400);
				out.println("修改用户备注失败！");
			}
		}
		out.flush();
		out.close();
	}

}
