package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;

import com.mlcss.bean.Courses;

public interface CoursesDAO {
	
		public boolean add(Courses course) ;
		public boolean delById(int id);
		public boolean update( Courses course);
		public Courses findById(int id);
		public List<Courses> findAll();
}
