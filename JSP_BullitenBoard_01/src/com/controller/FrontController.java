package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.command.ContentViewCommand;
import com.command.DeleteCommand;
import com.command.ListCommand;
import com.command.ModifyCommand;
import com.command.ReplyCommand;
import com.command.ReplyWriteViewCommand;
import com.command.WriteCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		// uri 부분에서 contextPath의 길이만큼만 잘라내면 mapping 주소만 남게된다.
		String mapping = uri.substring(contextPath.length());
		
		
		System.out.println("mapping is: " + mapping);
		
		
		// 글 쓰기 화면
		if(mapping.equals("/write_view.do")) {
			
			viewPage = "write_view.jsp";
			
		} else if(mapping.equals("/write.do")) {
			
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		} else if(mapping.equals("/list.do")) {
			
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			
		} else if(mapping.equals("/content_view.do")) {
			
			command = new ContentViewCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
			
		} else if(mapping.equals("/modify.do")) {
			
			command = new ModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		} else if(mapping.equals("/modify_view.do")) {
			
			command = new ContentViewCommand();
			command.execute(request, response);
			viewPage = "modify_view.jsp";
			
		} else if(mapping.equals("/delete.do")) {
			
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		} else if(mapping.equals("/reply_write_view.do")) {
			
			command = new ReplyWriteViewCommand();
			command.execute(request, response);
			viewPage = "reply_write_view.jsp";
			
		} else if(mapping.equals("/reply.do")) {
			
			command = new ReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		}
		
		
		// forward 하는 인터페이스
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
		
		
	}

}
