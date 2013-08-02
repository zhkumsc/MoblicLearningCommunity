package com.mlcss.servlet.user;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.mlcss.util.ServiceUtil;

/**
 * 测试登陆
 * @author fantasy
 *
 */
public class TestUserLogin {
	@Test
	public void testLogin() {
		try {
			//User u = new User(0, "123", ServiceUtil.toMD5("234234"), "abc@fsdf.com");
			//String jsonString = JSONObject.fromObject(u).toString();
			
			URL url = new URL("http://localhost:8080/MoblicLearningCommunity/UserLogin");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			dos.write(("email=abc@fsdf.com&password=" + ServiceUtil.toMD5("123")).getBytes());
			dos.flush();
			dos.close();
			System.out.println(conn.getResponseCode());
			//DataInputStream input = new DataInputStream(conn.getInputStream());
			//System.out.println(input.readUTF());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
