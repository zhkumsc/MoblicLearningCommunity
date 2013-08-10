package com.mlcss.servlet.user;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.User;
import com.mlcss.util.ServiceUtil;

/**
 * 单元测试，测试注册
 * @author fantasy
 *
 */
public class TestRegister {

	@Test
	public void testRegister() {
		try{
			User u = new User("ming", ServiceUtil.toMD5("123"), "kdjhld@msm.com","kjdkljfl");
			String jsonString = JSONObject.fromObject(u).toString();
			
			URL url = new URL("http://localhost:8080/MoblicLearningCommunity/UserRegister");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			dos.write(("json=" + jsonString).getBytes());
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
