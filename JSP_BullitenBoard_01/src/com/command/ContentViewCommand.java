package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;
import com.dto.DTO;

public class ContentViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		String id = request.getParameter("id");
		DAO dao = new DAO();
		DTO dto = dao.contentView(id);
		
		
		request.setAttribute("content_view", dto);

	}

}
