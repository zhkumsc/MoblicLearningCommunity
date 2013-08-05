package com.mlcss.servlet.message;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.CoursesNotice;

public class TestMessageSendCourseNotice {

	@Test
	public void testSen() throws Exception {
		CoursesNotice cn = new CoursesNotice();
		cn.setContent("Hello 测试提醒！");
		cn.setNoticeTitle("Hello 测试");
		cn.setCoursesId(1);
		
		String jsonString = JSONObject.fromObject(cn).toString();
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/MessageSendCourseNotice");
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
