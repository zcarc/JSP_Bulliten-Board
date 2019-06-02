package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;

public class ModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		DAO dao = new DAO();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		dao.modify(title, content, id);
		
	}
	
	

}
