package com.mlcss.servlet.course;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.Courses;
import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.util.DateTimeUtil;

public class TestCourseAdd {

	@Test
	private void testReceive() throws Exception{
		
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseAdd");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
//		Courses courses = new Courses();
//		courses.setCreateTime(DateTimeUtil.String2Date("2013-8-10 15:51:40"));
//		courses.setCreateby(createby)
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("json=" + 0).getBytes());
		dos.flush();
		dos.close();
		System.out.println(conn.getResponseCode());
		
		
		BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String jsonString = dis.readLine();
		System.out.println(jsonString);
		Courses c = (Courses) JSONObject.toBean(JSONObject.fromObject(jsonString), Courses.class);
		System.out.println(c);
		conn.disconnect();
	}
}
