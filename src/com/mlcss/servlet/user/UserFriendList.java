package com.mlcss.servlet.user;

import java.io.IOException;
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
		
		UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
		List<UserRelShip> list = ursdi.listAll();
		
		Map<String,List<UserRelShip>> map = new LinkedHashMap<String, List<UserRelShip>>();
		map.put("list", list);
		JSONObject jsonUser = JSONObject.fromObject(map);	    	
		System.out.println(jsonUser.toString());
	}

}
