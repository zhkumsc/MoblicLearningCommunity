package com.mlcss.servlet.course;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.Courses;
import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.bean.QuestionReply;
import com.mlcss.util.DateTimeUtil;
/**
 * @author jc
 */
public class TestQuestionreplyadd {

	@Test
	public void testReceive() throws Exception{
		
		URL url = new URL(
				"http://localhost:8080/MoblicLearningCommunity/service/CourseQusetionReply");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		
		QuestionReply qp= new QuestionReply();
//		courses.setCreateTime(DateTimeUtil.String2Date("2013-8-10 15:51:40"));
		qp.setContent("abc");
		qp.setQuestionid(9);
		qp.setUserid(8);
		
		String jsonString = JSONObject.fromObject(qp).toString();
		
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
