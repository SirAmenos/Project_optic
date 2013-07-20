

<%@page import="org.svoptic.dto.StockLens"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="org.svoptic.dto.UserDetail"%>
<%@page import="org.svoptic.service.LoginService" %>
<%@page import="org.svoptic.dto.Order"%>
<%@page import="org.svoptic.service.OrderService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>List of Your Orders</title>        
    </head>
    <body>  
    <center>
        <div id="mystyle">
                <b>SVOptical Official Website</b><br/>
                <%=new Date()%></br>
                <%
                    UserDetail user = (UserDetail) session.getAttribute("user");
                %>            
                <b>informations for this user: <%= user.getFirstName() + " " + user.getLastName()%></b>            
                <br/>
                <a href="logout.jsp">Logout</a>
                <a href="home.jsp">Home</a>
                <a href="DeleteOrder.jsp">Delete</a>
                <a href="UpdateOrder.jsp">Edit</a>
            </p>

            <table>
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>State</th>
                        <th>Order Date</th>
                        <th>Delivery Date</th>
                        <th>Diameter</th>
                        <th>Index</th>                        
                    </tr>
                </thead>
                <tbody>
                    <%
                        OrderService orderService = new OrderService();
                        List<Order> list = orderService.getStocksforUser(user.getId());                        
                        for (Order u : list) {
                        	StockLens p = u.getProduct();
                    %>
                    <tr>
                        <td><%=u.getOrderId()%></td>
                        <td><%=u.getState()%></td>
                        <td><%=u.getOrderDate().toString() %></td>
                        <td><%=u.getOrderDate()%></td>
                        <td><%=p.getDiameter()%></td>
                        <td><%=p.getIndex()%></td>
                    </tr>
                    <%}%>
                <tbody>
            </table>            
            <br/>
            <br/>do you want to update your information? <a href="update.jsp">Update</a></p>
        </div>

    </center>            
</body>
</html>
