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

import com.mlcss.bean.RemindUser;

public class testRemindUpdate {
	@Test
	public void test()throws Exception{
		RemindUser a=new RemindUser();
		//根据id改信息
		a.setId(7);
		a.setContent("qqqqqq");
		a.setIdentifying((byte) 0);
		a.setReceiverId(9);
		a.setReceived(true);
		
		
		
		
		
		String jsonString = JSONObject.fromObject(a).toString();
		System.out.println(jsonString);
		JSONObject o;
		o = JSONObject.fromObject(jsonString);
		RemindUser note=(RemindUser)JSONObject.toBean(o,RemindUser.class);
		System.out.println(note.getContent());
		HttpClient h= new DefaultHttpClient();
		HttpPost post=new HttpPost("http://localhost:8080/MoblicLearningCommunity/service/RemindUpdate");
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

}}
