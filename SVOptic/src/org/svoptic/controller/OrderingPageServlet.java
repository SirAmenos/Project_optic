package org.svoptic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.svoptic.dto.StockLens;
import org.svoptic.dto.UserDetail;
import org.svoptic.service.LoginService;
import org.svoptic.service.OrderService;

/**
 * Servlet implementation class OrderingPageServlet
 */
@WebServlet("/OrderingPageServlet")
public class OrderingPageServlet extends HttpServlet {
	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {

           	String index = request.getParameter("index");
           	String diameter = request.getParameter("diameter");
           	String category = request.getParameter("category");
           	String manufacturer = request.getParameter("manufacturer");
           	
           		
           	if(diameter != null)
	          	if(diameter.equals("None"))
	           		diameter = null;
	        if(index != null)   		
	            if(index.equals("None"))
	           		index = null;
	        if(category != null)   		
	            if(category.equals("None"))
	           		category = null;
	        if(manufacturer != null)   	
	          	if(manufacturer.equals("None"));
	           		manufacturer = null;
	           		
           	 OrderService orderService = new OrderService();
             List<StockLens> list = orderService.getStocks(index, manufacturer, category, diameter); 
           	
             request.setAttribute("list", list);
           		
           	RequestDispatcher dispatcher = request.getRequestDispatcher("OrderingPage.jsp");
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
}
