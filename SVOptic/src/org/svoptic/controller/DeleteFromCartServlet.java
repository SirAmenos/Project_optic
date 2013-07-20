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

import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.svoptic.dto.Order;
import org.svoptic.dto.StockLens;
import org.svoptic.dto.UserDetail;
import org.svoptic.service.OrderService;

/**
 * Servlet implementation class DeleteFromCart
 */
@WebServlet("/DeleteFromCartServlet")
public class DeleteFromCartServlet extends HttpServlet {
	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	
	    	OrderService orderService = new OrderService();
	    	UserDetail user = (UserDetail) request.getSession().getAttribute("user");
	    	Enumeration paramNames = request.getParameterNames();
	        while(paramNames.hasMoreElements()) {
	  	      String paramName = (String)paramNames.nextElement();
	  	      String paramValue = (String)request.getParameter(paramName);
	  	      System.out.println(paramName+","+paramValue);
	  	      //StockLens product = orderService.getStockById(Integer.parseInt(paramName));
	  	      //orderService.AddtoCart(user, product);
	  	    //  Integer id = Integer.parseInt("3");
	  	      orderService.deleteOrderById(Integer.parseInt(paramName));
	  	      
	  	      
	  	      
	        }
	        List<Order> list = orderService.getStocksforUser(user.getId());
	        request.setAttribute("list", list);
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
