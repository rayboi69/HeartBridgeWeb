package com.se452.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.service.UserUniversityServiceDao;



/**
 * Servlet implementation class AddUserUniversity
 */
@WebServlet("/AddUniversityController")
public class AddUserUniversityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserUniversityController() {
        super();
        entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession(true);
		String uis=session.getAttribute("userIdKey").toString();
		int uid=Integer.parseInt(uis);
		String uniName = request.getParameter("uni_name");
		UserUniversityServiceDao uusd=new UserUniversityServiceDao();
		uusd.setEntityManager(entityManager);
		try{
		uusd.addUserUniversity(uid, uniName);}
		catch(Exception e)
		{
			 response.sendRedirect("AddUniversity.jsp");	
		}
		//entityManager.close();
		//entityManagerFactory.close();
		 response.sendRedirect("functionList.jsp");
	}

}
