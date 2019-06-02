package com.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;
import com.dto.DTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		ArrayList<DTO> DTOList = dao.list();
		request.setAttribute("list", DTOList);
		
	}
	
	

}
