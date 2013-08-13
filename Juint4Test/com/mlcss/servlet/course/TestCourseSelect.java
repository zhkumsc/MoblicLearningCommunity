package com.mlcss.servlet.course;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.Courses;
import com.sun.jmx.snmp.Timestamp;
/**
 * @author jc
 */
public class TestCourseSelect {

	@Test
	public void testReceive() throws Exception{
		
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseSelect");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		int id = 2;
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("id=" + id).getBytes());
		System.out.println(conn.getResponseCode());
		dos.flush();
		dos.close();
		
		
		BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String injsonString = dis.readLine();
		JSONObject jsonObject = JSONObject.fromObject(injsonString);
		Courses c = (Courses) JSONObject.toBean(jsonObject, Courses.class);
		System.out.println(injsonString); 
		System.out.println(c); 
		dis.close();
		conn.disconnect();
	}
}
