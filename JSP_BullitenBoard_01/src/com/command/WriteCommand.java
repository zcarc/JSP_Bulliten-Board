package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;

public class WriteCommand implements Command { 

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		DAO dao = new DAO();
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		dao.write(name, title, content);
		
	}

}
