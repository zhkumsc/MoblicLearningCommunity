package com.mlcss.servlet.assistant;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

import net.sf.json.JSONObject;

import com.mlcss.bean.UserNotes;

public class testNoteAdd {
	@Test
	public void test()throws Exception{
		UserNotes a=new UserNotes();
		a.setUserid(8);
		a.setContent("qweerrqq");
		a.setTitle("test");
		String jsonString = JSONObject.fromObject(a).toString();
		System.out.println(jsonString);
		JSONObject o;
		o = JSONObject.fromObject(jsonString);
		UserNotes note=(UserNotes)JSONObject.toBean(o,UserNotes.class);
		System.out.println(note.getContent());
		HttpClient h= new DefaultHttpClient();
		HttpPost post=new HttpPost("http://localhost:8080/MoblicLearningCommunity/service/NoteAdd");
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
