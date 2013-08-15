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

import com.mlcss.bean.User;
import com.mlcss.dao.impl.UserDAOImpl;
/**
 *查找用户 客户端发送一个包含查找内容user和flag(用来判断根据email(此时flag=email)还是用户名(此时flag=name)来查找)的json
 * @author Administrator
 *返回一个user的json
 */
@SuppressWarnings("serial")
public class UserSelect extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userJson = request.getParameter("json");
		JSONObject jb = JSONObject.fromObject(userJson);
		String flag = jb.getString("flag");
		String str = jb.getString("str");
		System.out.println(str);
		System.out.println(flag);
		
		UserDAOImpl udi = new UserDAOImpl();
		if(flag.equals("email")){
			User user = udi.findByEmail(str);
			if(user!=null){
				JSONObject jsonUser = JSONObject.fromObject(user);
				out.print(jsonUser);
			}else{
				out.print("用户不存在！");
			}
		}else if(flag.equals("name")){
			List<User> list = udi.findByName(str);
			if(list!=null){
				Map<String, List<User>> map = new LinkedHashMap<String, List<User>>();
				map.put("list", list);
				JSONObject jsonUser = JSONObject.fromObject(map);
				System.out.println(jsonUser);
				out.print(jsonUser);
			}else{
				out.print("用户不存在！");
			}
		}else{
			out.print("查找错误！");
		}
	}

}
