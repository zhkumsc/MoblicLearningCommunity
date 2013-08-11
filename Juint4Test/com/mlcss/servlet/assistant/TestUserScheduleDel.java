package com.mlcss.servlet.assistant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;


public class TestUserScheduleDel {

	@Test
	public void testReceive() throws Exception {
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/UserScheduleDel");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		int id = 3;
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.write(("id="+id).getBytes());
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
