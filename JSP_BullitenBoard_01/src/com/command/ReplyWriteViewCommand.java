package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;
import com.dto.DTO;

public class ReplyWriteViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		String id = request.getParameter("id");
		DTO dto = dao.contentView(id);
		
		request.setAttribute("reply_write_view", dto);

	}

}
