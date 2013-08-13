package com.mlcss.servlet.course;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.CoursesUserInfo;
/**
 * @author jc
 */
public class TestCourseMemberRename {

	@Test
	public void testReceive() throws Exception {
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseMemberRename");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		CoursesUserInfo coursesUserInfo = new CoursesUserInfo();
		coursesUserInfo.setUserId(8);
		coursesUserInfo.setCoursesId(2);
		coursesUserInfo.setRemark("dsf 明");
		
		String jsonString = JSONObject.fromObject(coursesUserInfo).toString();
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("json="+jsonString).getBytes());
		System.out.println(conn.getResponseCode());
		dos.flush();
		dos.close();
		
		BufferedReader dis = null;
		dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String injsonString = dis.readLine();
		System.out.println("coursesUserInfo:"+injsonString); 
		dis.close();
		conn.disconnect(); 

	}
}
