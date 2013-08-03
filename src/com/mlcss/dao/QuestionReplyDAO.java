package com.mlcss.dao;

import java.util.List;

import com.mlcss.bean.QuestionReply;

public interface QuestionReplyDAO {
	
		
			public boolean add(QuestionReply question);
			public boolean delById(int id);
			public boolean delAllQuesttions(int questionid);
			public boolean update( QuestionReply question);
			public List<QuestionReply> findAll(int questionid);
			public QuestionReply findById(int id);

	}

