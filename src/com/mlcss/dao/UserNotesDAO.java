package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;


import com.mlcss.bean.UserNotes;

public interface UserNotesDAO {
	public boolean add(UserNotes notes);
	public boolean delete(int id);
	public boolean update(UserNotes notes);
	public boolean share(UserNotes notes);
	public boolean unshare(UserNotes notes);
	public UserNotes findById(int id);
	public List<UserNotes> findByUserId(int userid);
	

}
