<%-- 
    Document   : index
    Created on : Nov 5, 2012, 6:06:23 PM
    Author     : mano
--%>

<%@page import="org.svoptic.dto.StockLens"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="org.svoptic.dto.StockLens"%>
<%@page import="org.svoptic.dto.UserDetail"%>
<%@page import="org.svoptic.dto.Order"%>
<%@page import="org.svoptic.service.LoginService" %>
<%@page import="org.svoptic.service.OrderService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>Deleting Page</title>        
    </head>
    <body>  
    <center>
        <div id="mystyle">
                <b>SVOptical Official Website</b><br/>
                <%=new Date()%></br>
                <%
                    UserDetail user = (UserDetail) session.getAttribute("user");
 
                %>            
                <b>Welcome <%= user.getFirstName() + " " + user.getLastName()%></b>            
                <br/>
                <a href="logout.jsp">Logout</a>
                <a href="UserTrack.jsp">UserTrack</a>
            </p>
            
   
			
			

            <table>
                <thead>
                    <tr>
                    	<th>Edit</th>
                        <th>Stock ID</th>
                        <th>Diameter</th>
                        <th>Index</th>
                        <th>Reg Price</th>
                        <th>Web Price</th>                        
                    </tr>
                </thead>
                <tbody>
                <form action="EditCardServlet" method="post"> 
                    <%
                    OrderService orderService = new OrderService();
                    List<Order> list2 =  orderService.getStocksforUser(user.getId());  
                        for (Order u : list2) {
                    %>
                    <tr>
                    	<td>
                    	<input type="checkbox", name="<%=u.getOrderId() %>" ,value="<%=u.getOrderId() %>">
                    	</td>
                        <td><%=u.getOrderId()%></td>	
                        <td><%=u.getState()%></td>
                        <td><%=u.getOrderDate()%></td>
                        <td><%=u.getDeliveryDate()%></td>
                        <td><input type="text" name="<%=u.getOrderId() %>+"NUM"" id="userId" value=<%= u.getNumber() %>  /></td>
                    </tr>
                    <%}%>
                <tbody>
            </table> 
            	<button type="submit">Edit cart</button> 
            </form>          
            <br/>
            <br/>do you want to update your information? <a href="update.jsp">Update</a></p>
        </div>

    </center>            
</body>
</html>
