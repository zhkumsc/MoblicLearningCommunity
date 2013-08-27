package com.mlcss.servlet.assistant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.bean.CoursesSchedule;

/**
 * @author jc
 */
public class TestGetUserSchedules {

	@Test
	public void testReceive() throws Exception {
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/GetUserSchedules");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		int id = 8;
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("id="+id).getBytes());
		System.out.println(conn.getResponseCode());
		dos.flush();
		dos.close();
		
		BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String injsonString = dis.readLine();
		System.out.println(injsonString);
		Collection c = JSONArray.toCollection(JSONArray.fromObject(injsonString), CoursesSchedule.class);
		System.out.println(c.size());
		for(Object o : c) {
			System.out.println(o.toString());
		}
		dis.close();
		conn.disconnect();
	}
}
