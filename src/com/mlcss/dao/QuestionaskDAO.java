package com.mlcss.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mlcss.bean.QuestionAsk;

public interface QuestionaskDAO {
	
		
			public boolean add(QuestionAsk question);
			public boolean delById(int bean);
			public boolean delAllQuesttions(int coursesid);
			public boolean update( QuestionAsk question);
			public List<QuestionAsk> findall(int coursesId);
			public QuestionAsk findById(int id);

	}

