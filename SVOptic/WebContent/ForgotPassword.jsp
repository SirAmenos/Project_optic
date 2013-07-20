<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>type your user name</title>  

</head>
   <body>
    <center>
        <div id="mystyle" class="myform">
            <form id="form" name="form" method="post" action="ForgotPassword">
                
                <p>Please enter your User Name
                    <br/>New User? <a href="Register.jsp">Register</a></p>
                <label>User ID
                    <span class="small">Enter your user ID</span>
                </label>
                <input type="text" name="userId" id="userId" />

                <button type="submit">Send Email</button>
                <div class="spacer"></div>
            </form>
        </div>
    </center>
</body>
</html>