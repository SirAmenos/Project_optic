package org.svoptic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.svoptic.dto.UserDetail;
import org.svoptic.service.LoginService;
import org.svoptic.service.SendMail;


	@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
	public class LoginServlet extends HttpServlet {

	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {        
	        String userName = request.getParameter("userId");        
	        String password = request.getParameter("password");
	        Cookie userNameCookie = new Cookie("userName", userName);
	        Cookie passwordCookie = new Cookie("password", password);
	        response.addCookie(userNameCookie);
	        response.addCookie(passwordCookie);
	        System.out.println(userName);
	        LoginService loginService = new LoginService();
	        request.getSession().setAttribute("loginService", loginService);
	        boolean result = loginService.authenticate(userName, password);
	        UserDetail user = loginService.getUserByUserId(userName);
	        if(result == true){
	            request.getSession().setAttribute("user", user);            
	            response.sendRedirect("home.jsp");
	        }
	        else{
	        	loginService.setError("wrong password or user name");
	            response.sendRedirect("LoginRetry.jsp");
	            
	        }
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>


}
