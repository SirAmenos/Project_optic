<%-- 
    Document   : index
    Created on : Nov 5, 2012, 6:06:23 PM
    Author     : mano
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="org.svoptic.dto.UserDetail"%>
<%@page import="org.svoptic.service.LoginService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>Home Page</title>        
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
                <a href="OrderingPageServlet">Order Products</a>
                <%if(user.getRank().equals("1")){ %>
                <a href="AdminPrivilage.jsp" >Admin Privilage</a>
                <%} %>
             
            <p>

            <table>
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Middle Name</th>
                        <th>Last Name</th>
                        <th>email</th>                        
                    </tr>
                </thead>
                <tbody>
                    <%
                        LoginService loginService = new LoginService();
                        List<UserDetail> list = loginService.getListOfUsers();
                        for (UserDetail u : list) {
                    %>
                    <tr>
                        <td><%=u.getId()%></td>
                        <td><%=u.getFirstName()%></td>
                        <td><%=u.getLastName()%></td>
                        <td><%=u.getEmail()%></td>
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
