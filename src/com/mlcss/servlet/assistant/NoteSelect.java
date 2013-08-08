package com.mlcss.servlet.assistant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlcss.bean.UserNotes;
import com.mlcss.dao.UserNotesDAO;
import com.mlcss.dao.impl.UserNotesDAOImpl;

public class NoteSelect extends HttpServlet {
	private UserNotesDAO usernotesDAO = new UserNotesDAOImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String notejsonString = request.getParameter("json");
		System.out.println(notejsonString);
		JSONObject o;
		o = JSONObject.fromObject(notejsonString);
		UserNotes note = (UserNotes) JSONObject.toBean(o, UserNotes.class);
		// 如果提供笔记id就只找单个笔记，如果提供userid就找该用户的全部笔记
		if (note.getId() != 0) {
			UserNotes k = usernotesDAO.findById(note.getId());
			if (k != null) {
				String anote = JSONObject.fromObject(k).toString();
				out.print(anote);
				return;
			} else {
				response.setStatus(400);
				out.print("找不到笔记");
				System.out.println("找不到笔记");
				return;
			}

		}
		else if (note.getUserid() != 0) {
			List<UserNotes> noteslist = new ArrayList<UserNotes>();
			noteslist = usernotesDAO.findByUserId(note.getUserid());
			if (noteslist != null) {
				String notes = JSONArray.fromObject(noteslist).toString();
				out.print(notes);
				return;
			} else {
				response.setStatus(400);
				out.print("找不到笔记");
				System.out.println("找不到笔记");
				return;
			}
		}

	}

}
