package org.svoptic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.svoptic.dto.UserDetail;
import org.svoptic.service.LoginService;
import org.svoptic.service.OrderService;
import org.svoptic.service.UpdateService;

/**
 * Servlet implementation class UserTrackServlet
 */
@WebServlet("/UserTrackServlet")
public class UserTrackServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
 
    	
 
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
