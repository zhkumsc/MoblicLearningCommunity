package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.User;
import com.mlcss.bean.UserGroups;
import com.mlcss.bean.UserRelShip;
import com.mlcss.dao.impl.UserDAOImpl;
import com.mlcss.dao.impl.UserGroupsDAOImpl;
import com.mlcss.dao.impl.UserRelShipDAOImpl;
/* String JsonString = "{\"friendId\":10, \"userId\":27, \"friendNote\":\"胖子\"}";
 * 如果客户端没有传过来friendNote，则使用好友用户名为好友备注
 * 增加好友,将好友添加到默认分组
 */
@SuppressWarnings("serial")
public class UserFriendAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String userJson = request.getParameter("json");
		System.out.println(userJson);
		JSONObject o = JSONObject.fromObject(userJson);
		UserRelShip urs = (UserRelShip)JSONObject.toBean(o, UserRelShip.class);
		urs.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		if(!invalid(urs)){
			response.setStatus(400);
			out.print("提交表单带有问题");
			System.out.println("提交表单带有问题");
			return;
		}
		
		//如果不设置好友备注，则默认使用好友的用户名name
		if(urs.getFriendNote()==null){
			UserDAOImpl udi = new UserDAOImpl();
			User u = udi.findById(urs.getFriendId());
			urs.setFriendNote(u.getName());
		}
		
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		
		//将好友添加到默认分组
		UserGroupsDAOImpl ugdi = new UserGroupsDAOImpl();
		UserGroups ug = ugdi.findFriendGroups(urs.getUserId(), "我的好友");
		urs.setGroupId(ug.getId());
		
		if(ursdi.findByUserIdAndFriendId(urs.getUserId(), urs.getFriendId())!=null){
			response.setStatus(400);
			out.print("该好友已经存在");
			System.out.println("该好友已经存在!");
			return;
		}
		
		if(ursdi.add(urs)){
			UserDAOImpl udi = new UserDAOImpl();
			User u = udi.findById(urs.getUserId());
			UserRelShip urs1 = new UserRelShip(urs.getFriendId(),urs.getUserId(),urs.getGroupId(),urs.getCreateTime(),u.getName());
			ursdi.add(urs1);
			out.print("添加好友成功！");
		}else{
			response.setStatus(500);
			out.print("服务器内部问题");
			System.out.println("服务器内部问题");
			return;
		}
		out.close();
	}

	private boolean invalid(UserRelShip urs) {
		
		if((Object)urs.getUserId() == null || (Object)urs.getFriendId() == null){
			return false;
		}
		return true;
	}

}
