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
<%@page import="org.svoptic.service.LoginService" %>
<%@page import="org.svoptic.service.OrderService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="list" type="java.util.List" scope="request" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>Ordering Page</title>        
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
            
            <b>search by option for your considered stock  </b>
           <form action="OrderingPageServlet" method="post"> 
				<select name="category">
				  <option value="None">-None-</option>
				  <option value="cat1">cat1</option>
				  <option value="cat2">cat2</option>
				  <option value="cat3">cat3</option>
				</select>
				<br>			
				<select name="manufacturer" >
				  <option value="None">-None-</option>
				  <option value="man1">man1</option>
				  <option value="man2">man2</option>
				  <option value="manu">manu</option>
				</select>
				<br>
				<select name="index">
				  <option value="None">-None-</option>
				  <option value="index">index</option>
				  <option value="index2">index2</option>
				  <option value="index3">index3</option>
				</select>
				<br>
				<select name="diameter">
				  <option value="None">-None-</option>
				  <option value="diam">diam</option>
				  <option value="diam2">diam2</option>
				  <option value="diameter">diameter</option>
				</select>
				<br>
				<button type="submit">search</button>
			</form>
				
			
			

            <table>
                <thead>
                    <tr>
                    	<th>Add to Card</th>
                        <th>Stock ID</th>
                        <th>Diameter</th>
                        <th>Index</th>
                        <th>Reg Price</th>
                        <th>Web Price</th>                        
                    </tr>
                </thead>
                <tbody>
                <form action="AddtoCartServlet" method="post"> 
                    <%
                    List<StockLens> list2 = list ;  
                        for (StockLens u : list2) {
                    %>
                    <tr>
                    	<td>
                    	<input type="checkbox", name="<%=u.getStockId() %>" ,value="<%=u.getStockId() %>">
                    	</td>
                        <td><%=u.getStockId()%></td>	
                        <td><%=u.getDiameter()%></td>
                        <td><%=u.getIndex()%></td>
                        <td><%=u.getRegPrice()%></td>
                        <td><%=u.getWebPrice()%></td>
                    </tr>
                    <%}%>
                <tbody>
            </table> 
            	<button type="submit">AddtoCart</button> 
            </form>          
            <br/>
            <br/>do you want to update your information? <a href="update.jsp">Update</a></p>
        </div>

    </center>            
</body>
</html>
