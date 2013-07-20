<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="org.svoptic.service.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Login Page</title>
    </head>
    

        
<body>
    <center>
        <div id="mystyle" class="myform">
            <form id="form" name="form" method="post" action="LoginServlet">
                <h1>Login</h1>
                <p>Please enter your login information
                    <br/>New User? <a href="Register.jsp">Register</a></p>
                <label>User ID
                    <span class="small">Enter your user ID</span>
                </label>
                <input type="text" name="userId" id="userId" value=<%= CookieUtilities.getCookieValue(request, "userName", "") %>  />

                <label>Password
                    <span class="small">Min. size 6 chars</span>
                </label>
                <input type="password" name="password" id="password"  />
              
                <button type="submit">Sign-in</button>
                <div class="spacer"></div>
                <p> 
                <br/>Forget your password? <a href="ForgotPassword.jsp">Send Email</a>
                </p>
            </form>
        </div>
    </center>
</body>
</html>
