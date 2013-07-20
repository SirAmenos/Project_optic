package org.svoptic.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.svoptic.dto.StockLens;
import org.svoptic.dto.UserDetail;
import org.svoptic.service.OrderService;

/**
 * Servlet implementation class EditCardServlet
 */
@WebServlet("/EditCardServlet")
public class EditCardServlet extends HttpServlet {
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	
	    	OrderService orderService = new OrderService();
	    	UserDetail user = (UserDetail) request.getSession().getAttribute("user");
	    	Enumeration paramNames = request.getParameterNames();
	        while(paramNames.hasMoreElements())
	        {
	  	      String paramName = (String)paramNames.nextElement();
	  	      String paramValue = (String)request.getParameter(paramName);
	  	      if(paramValue.equals("on"))
	  	      {
		  	      System.out.println(paramName+","+paramValue);
		  	      String paramValue2 = request.getParameter(paramName+"+");
		  	      System.out.println(paramName+"+"+","+paramValue2);
		  	      orderService.editOrderById(Integer.parseInt(paramName), paramValue2);
		  	  }
	  	      
	 
	        }
	  	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserTrack.jsp");
		    dispatcher.forward(request, response);
		 
	  

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
