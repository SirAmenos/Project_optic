<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="org.svoptic.dto.*" %>
<%@ page import="org.svoptic.service.*" %>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>All Orders</title>  
</head>
<body>
	<div id="mystyle" class="myform">
		<form id="form" name="form" method="post" action="AdminControllerServlet">
			<table>
				<thead>
					<tr>
						<th>change State</th>
					    <th>Order ID</th>
					    <th>Consumer</th>
                        <th>State</th>
                        <th>Order Date</th>
                        <th>Delivery Date</th>
                    </tr>
				</thead>
				<%
					OrderService orderSerivce = new OrderService();
					List <Order> list = orderSerivce.getAllOrders();
					for(Order o : list){
				
				%>
					<tr>
						<th>
							delete
							<input type ="radio" name ="<%=o.getOrderId() %>" value ="delete">
							<br>
							change
							<input type ="radio" name ="<%=o.getOrderId() %>" value ="change">
							
							
						</th>
						<th>
						<select name="<%=o.getOrderId()+"+" %>">
				  			<option value="None">-None-</option>
				  			<option value="Ready">Ready</option>
				  			<option value="Ignored">Ignored</option>
				  			<option value="In Process">In Process</option>
						</select>
						</th>
						<th> <%=o.getOrderId() %></th>
						<th> <%=o.getCostumer().getUserName() %></th>
						<th> <%=o.getState()%></th>
						<th> <%=o.getOrderDate() %></th>
						<th> <%=o.getDeliveryDate() %></th>

					
					</tr>
				<%} %>		
			
			</table>
						<button type="submit">Confirm</button>
		</form>
	
	
	
	
	</div>
</body>
</html>