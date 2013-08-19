package com.mlcss.servlet.course;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.QuestionAsk;
/**
 * @author 
 */
public class TestQuetionAskAdd {

	@Test
	public void testReceive() throws Exception{
		
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseQuestionAsk");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		QuestionAsk  que=new QuestionAsk();
//		courses.setCreateTime(DateTimeUtil.String2Date("2013-8-10 15:51:40"));
		que.setCreateby(8);
		que.setTitle("ai");
		que.setCoursesid(6);
		que.setContent("aaaa");
		
		String jsonString = JSONObject.fromObject(que).toString();
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("json=" + jsonString).getBytes());
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
