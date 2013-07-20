package org.svoptic.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.svoptic.dto.UserDetail;
import org.svoptic.service.LoginService;
import org.svoptic.service.SendMail;
import org.svoptic.service.UpdateService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException { 
    	UserDetail usertemp =  (UserDetail) request.getSession().getAttribute("user");
        String userId = usertemp.getUserName();       
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(userId, password);
        UserDetail user = loginService.getUserByUserId(userId);
        if(result == true){

        	UpdateService updateService = new UpdateService();
        	user = updateService.UpdateUserByUserId(userId, request.getParameter("firstName"), 
        			request.getParameter("lastName"), request.getParameter("city"), request.getParameter("country"),
        			request.getParameter("province"), request.getParameter("phone"), request.getParameter("FAX"),
        			request.getParameter("Email"), request.getParameter("postalCode"), request.getParameter("company"),
        			request.getParameter("firstAddr"), request.getParameter("secondAddr"));
    
        	
        	
        	
            request.getSession().setAttribute("user", user);            
            response.sendRedirect("home.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
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
}
