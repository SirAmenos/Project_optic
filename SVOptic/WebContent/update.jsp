<%@page import="org.svoptic.dto.UserDetail"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>update your information</title>
</head>
<% UserDetail userDetail = (UserDetail) request.getSession().getAttribute("user"); %>

<body>
	<center>
        <div id="mystyle" class="myform">
			<form action="UpdateServlet" method="post">
				<table>
					<tr>
						<td align="left">First Name<sup>*</sup></td>
						<td align="Right"> <input name="firstName" type="text" value="<%=userDetail.getFirstName()%>">
						
					</tr>
				
					<tr>
						<td align="left">Last Name:</td>
						<td align="Right"> <input name="lastName" type="text" value="<%=userDetail.getLastName()%>">
								
					</tr>
					
					<tr>
						<td align="left">Company:</td>
						<td align="Right"> <input name="company" type="text" value="<%=userDetail.getCompany()%>">	
							
					</tr>
				
					<tr>
						<td align="left">Addres 1:</td>
						<td align="Right"> <input name="firstAddr" type="text" value="<%=userDetail.getFirstAddr()%>">
								
					</tr>
						
					<tr>
						<td align="left">Addres 2:</td>
						<td align="Right"> <input name="secondAddr" type="text" value="<%=userDetail.getSecondAddr()%>">
								
					</tr>
						
					<tr>
						<td align="left">City:</td>
						<td align="Right"> <input name="city" type="text" value="<%=userDetail.getCity()%>">
								
					</tr>
					
					<tr>
						<td align="left">Country:</td>
						<td align="left"> 
						<select  name="country">
							<option value="canada">Canada
							</option>
							<option value="united states">United States
							</option>
						</select>
					
					</tr>
			
					<tr>
						<td align="left">Province:</td>
						<td align="Left"> 
						<select  name="province">
							<option value="ontario">ontario
							</option>
							<option value="alberta">alberta
							</option>
						</select>
					</tr>
			
					
					<tr>
						<td align="left">Postal Code:</td>
						<td align="Right"> <input name="postalCode" type="text" value="<%=userDetail.getPostalCode()%>">
								
					</tr>		
			
					<tr>
						<td align="left">Phone:</td>
						<td align="Right"> <input name="phone" type="text" value="<%=userDetail.getPhone()%>">	
						
					</tr>
					
					
					<tr>
						<td align="left">FAX:</td>
						<td align="Right"> <input name="FAX" type="text" value="<%=userDetail.getFAX()%>">	
							
					</tr>		
					
					<tr>
						<td align="left">Email:</td>
						<td align="Right"> <input name="Email" type="text" value="<%=userDetail.getEmail()%>">
								
					</tr>
						
				
				
					<tr>
						<td align="left">Password:</td>
						<td align="Right"> <input name="password" type="text" value="">
				
					<tr>
						<td align="center"><input type="submit">
					</tr>
					 		
				</table>
			
			</form>
		</div>
	</center>
	



	
</body>


</html>