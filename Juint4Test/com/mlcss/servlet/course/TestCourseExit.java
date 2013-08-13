package com.mlcss.servlet.course;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.CoursesFollow;
/**
 * @author jc
 */
public class TestCourseExit {

	@Test
	public void testReceive() throws Exception {
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseExit");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		int id = 12;
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("id="+12).getBytes());
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
