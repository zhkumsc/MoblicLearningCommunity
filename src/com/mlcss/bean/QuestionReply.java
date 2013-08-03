package com.mlcss.bean;

import java.sql.Timestamp;

public class QuestionReply {
     private int  id;
     private int questionid;
     private int userid;
     private String content;
     private Timestamp createtime;
		@Override
	public String toString() {
		return "QuestionReply [id=" + id + ", questionid=" + questionid
				+ ", userid=" + userid + ", content=" + content
				+ ", createtime=" + createtime + "]";
	}
		
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
