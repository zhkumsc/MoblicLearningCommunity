package com.mlcss.servlet.assistant;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.mlcss.bean.UserNotes;

public class testNoteShare {
	@Test
	public void testshare()throws Exception{
		UserNotes a=new UserNotes();
		a.setId(4);
		a.setIsshared(true);
		String jsonString = JSONObject.fromObject(a).toString();
		System.out.println(jsonString);
		JSONObject o;
		o = JSONObject.fromObject(jsonString);
		UserNotes note=(UserNotes)JSONObject.toBean(o,UserNotes.class);
		System.out.println(note.getContent());
		HttpClient h= new DefaultHttpClient();
		HttpPost post=new HttpPost("http://localhost:8080/MoblicLearningCommunity/service/NoteShare");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("json", jsonString));
		
		try
		{
		// 设置请求参数
		post.setEntity(new UrlEncodedFormEntity(
		params, HTTP.UTF_8));
		// 发送POST请求
		HttpResponse response = h.execute(post);
		// 如果服务器成功地返回响应
		if (response.getStatusLine().getStatusCode() == 200);
		{
		String result = EntityUtils.toString(response.getEntity());
		System.out.println(result);
		}
		}catch(Exception e){
		e.printStackTrace();

		}

	}
	@Test
	public void testunshare()throws Exception{
		UserNotes a=new UserNotes();
		a.setId(4);
		a.setIsshared(false);
		
		String jsonString = JSONObject.fromObject(a).toString();
		System.out.println(jsonString);
		JSONObject o;
		o = JSONObject.fromObject(jsonString);
		UserNotes note=(UserNotes)JSONObject.toBean(o,UserNotes.class);
		System.out.println(note.getContent());
		HttpClient h= new DefaultHttpClient();
		HttpPost post=new HttpPost("http://localhost:8080/MoblicLearningCommunity/service/NoteShare");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("json", jsonString));
		
		try
		{
		// 设置请求参数
		post.setEntity(new UrlEncodedFormEntity(
		params, HTTP.UTF_8));
		// 发送POST请求
		HttpResponse response = h.execute(post);
		// 如果服务器成功地返回响应
		if (response.getStatusLine().getStatusCode() == 200);
		{
		String result = EntityUtils.toString(response.getEntity());
		System.out.println(result);
		}
		}catch(Exception e){
		e.printStackTrace();

		}

	}
}
