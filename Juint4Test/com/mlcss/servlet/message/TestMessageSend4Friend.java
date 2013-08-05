package com.mlcss.servlet.message;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.UserChatrecords;

public class TestMessageSend4Friend {

	@Test
	public  void sendMsg() throws Exception {
		UserChatrecords ucr = new UserChatrecords();
		ucr.setFriendid(2);
		ucr.setUserid(1);
		ucr.setContent("Hello 中国!");
		
		String jsonString = JSONObject.fromObject(ucr).toString();
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/MessageSend4Friend");
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
