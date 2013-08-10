package com.mlcss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlcss.bean.UserRelShip;
import com.mlcss.dao.impl.UserRelShipDAOImpl;
/**
 * 列出所有好友
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserFriendList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int userId = (Integer)request.getSession().getAttribute("userId");
		
		/*//下面这段代码时测试代码
		String jsonString = request.getParameter("json");
		JSONObject jb = JSONObject.fromObject(jsonString);
		int userId = jb.getInt("userId");*/
		
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		List<UserRelShip> list = ursdi.listAll(userId);
		
		if(list==null){
			out.print("该用户暂时没有好友！");
		}
		
		Map<String,List<UserRelShip>> map = new LinkedHashMap<String, List<UserRelShip>>();
		map.put("list", list);
		JSONObject jsonUser = JSONObject.fromObject(map);	    	
		System.out.println(jsonUser.toString());
		out.print(jsonUser.toString());
		out.close();
	}

}
