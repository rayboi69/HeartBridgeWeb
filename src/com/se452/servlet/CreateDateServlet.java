package com.se452.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.AppUser;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class CreateDateServlet
 */
@WebServlet("/CreateDateServlet")
public class CreateDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateDate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user1Id = 11;
		int user2Id = 12;
		
		String url ="/CreateDate.jsp";
		
			UserServiceDao us = new UserServiceDao();
			AppUser user1 = us.getUser(user1Id);
			AppUser user2 = us.getUser(user2Id);
			
			request.setAttribute("user1", user1.getUserName());
			request.setAttribute("user2", user2.getUserName());
			
			us.finalCommit();
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
