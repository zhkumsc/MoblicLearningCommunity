package com.mlcss.servlet.message;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.mlcss.bean.CoursesChatRecords;

public class TestMessageGet4Course {
	
	@Test
	public void testReceive() throws Exception {
		
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/MessageGet4Course");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("state=" + 0).getBytes());
		dos.flush();
		dos.close();
		System.out.println(conn.getResponseCode());
		BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String jsonString = dis.readLine();
		System.out.println(jsonString);
		Collection c = JSONArray.toCollection(JSONArray.fromObject(jsonString), CoursesChatRecords.class);
		System.out.println(c.size());
		for(Object o : c) {
			System.out.println(o.toString());
		}
		conn.disconnect();
	}
}
