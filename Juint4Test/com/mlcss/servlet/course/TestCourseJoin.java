package com.mlcss.servlet.course;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import net.sf.json.JSONObject;

import com.mlcss.bean.CoursesFollow;
/**
 * @author jc
 */

public class TestCourseJoin {

	@Test
	public void testReceive() throws Exception {
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseJoin");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		CoursesFollow coursesFollow = new CoursesFollow();
		coursesFollow.setCoursesId(2);
		coursesFollow.setUserId(10);
		
		String jsonString = JSONObject.fromObject(coursesFollow).toString();
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("json="+jsonString).getBytes());
		System.out.println(conn.getResponseCode());
		dos.flush();
		dos.close();
		
		BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String injsonString = dis.readLine();
		System.out.println(injsonString); 
		dis.close();
		conn.disconnect();

	}
}
