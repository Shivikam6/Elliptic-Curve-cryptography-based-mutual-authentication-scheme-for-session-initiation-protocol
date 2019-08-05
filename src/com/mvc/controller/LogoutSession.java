package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutSession
 */
@WebServlet("/LogoutSession")
public class LogoutSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false); // Fetch session object 
														// & 
														// Get an HttpSession related to this request, if no session exist don't create a new one.
		if (session != null) 							// If session is not null
		{
			System.out.println("Logged out");
			session.invalidate(); 						// removes all session attributes bound to the session
			System.out.println("Session : " + session);
			Cookie ck=new Cookie("name","");  
	        ck.setMaxAge(0);  
	        response.addCookie(ck);  
	        
			request.setAttribute("msg", "You have logged out successfully");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			//return;
	
		}
	}

		
	

}
