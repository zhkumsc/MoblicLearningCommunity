package com.mlcss.servlet.message;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.CoursesChatRecords;

public class TestMessageSend4Course {

	@Test
	public void testSend() throws Exception {
		
		CoursesChatRecords ccr = new CoursesChatRecords();
		ccr.setCoursesId(1);
		ccr.setSendId(1);
		ccr.setContent("hello 重构的世界！");
		String jsonString = JSONObject.fromObject(ccr).toString();
System.out.println(jsonString);		

		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/MessageSend4Course");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("json=" + jsonString).getBytes());
		dos.flush();
		dos.close();
		System.out.println(conn.getResponseCode());
	}

}
