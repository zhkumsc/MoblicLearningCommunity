package com.mlcss.servlet.assistant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.CoursesSchedule;

public class TestUserScheduleUpdate {

	@Test
	public void testReceive() throws Exception {
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/UserScheduleUpdate");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		CoursesSchedule coursesSchedule = new CoursesSchedule();
		coursesSchedule.setCoursesId(2);
		coursesSchedule.setCoursesPlace("教学楼110");
		coursesSchedule.setTeatherId(10);
		coursesSchedule.setCoursesTime("2013-08-02 17:58:11");
		coursesSchedule.setUserId(9);
		
		String jsonString = JSONObject.fromObject(coursesSchedule).toString();
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
