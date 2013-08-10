package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;


import com.mlcss.bean.UserNotes;

public interface UserNotesDAO {
	//add需要参数是suerid,标题，内容
	public boolean add(UserNotes notes);
	public boolean delete(int id);
	public boolean update(UserNotes notes);
	public boolean share(UserNotes notes);
	public boolean unshare(UserNotes notes);
	public UserNotes findById(int id);
	public List<UserNotes> findByUserId(int userid);
	

}
