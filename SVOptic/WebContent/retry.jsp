<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="registerService" type="org.svoptic.service.RegisterService" scope="session" />
<jsp:useBean id="userDetail" type="org.svoptic.dto.UserDetail" scope="session"/>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Try Again</title>
</head>
<body>
	<center>
        <div id="mystyle" class="myform">
			<form action="RegisterServlet" method="post">
				<table>
					<tr>
						<td align="left">First Name<sup>*</sup></td>
						<td align="Right"> <input name="firstName" type="text" value="<%=userDetail.getFirstName()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("firstName")%></font>
					</tr>
				
					<tr>
						<td align="left">Last Name:</td>
						<td align="Right"> <input name="lastName" type="text" value="<%=userDetail.getLastName()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("secondName")%></font>		
					</tr>
					
					<tr>
						<td align="left">Company:</td>
						<td align="Right"> <input name="company" type="text" value="<%=userDetail.getCompany()%>">	
						<br><font size=2 color=red><%=registerService.getErrorMsg("company")%></font>	
					</tr>
				
					<tr>
						<td align="left">Addres 1:</td>
						<td align="Right"> <input name="firstAddr" type="text" value="<%=userDetail.getFirstAddr()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("firstAddr")%></font>		
					</tr>
						
					<tr>
						<td align="left">Addres 2:</td>
						<td align="Right"> <input name="secondAddr" type="text" value="<%=userDetail.getSecondAddr()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("secondAddr")%></font>		
					</tr>
						
					<tr>
						<td align="left">City:</td>
						<td align="Right"> <input name="city" type="text" value="<%=userDetail.getCity()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("city")%></font>		
					</tr>
					
					<tr>
						<td align="left">Country:</td>
						<td align="left"> 
						<select  name="country">
							<option value="canada">Canada
							</option>
							<option value="united states">United States
							</option>
					
					</tr>
			
					<tr>
						<td align="left">Province:</td>
						<td align="Left"> 
						<select  name="province">
							<option value="ontario">ontario
							</option>
							<option value="alberta">alberta
							</option>
					</tr>
			
					
					<tr>
						<td align="left">Postal Code:</td>
						<td align="Right"> <input name="postalCode" type="text" value="<%=userDetail.getPostalCode()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("postalCode")%></font>		
					</tr>		
			
					<tr>
						<td align="left">Phone:</td>
						<td align="Right"> <input name="phone" type="text" value="<%=userDetail.getPhone()%>">	
						<br><font size=2 color=red><%=registerService.getErrorMsg("phone")%></font>	
					</tr>
					
					
					<tr>
						<td align="left">FAX:</td>
						<td align="Right"> <input name="FAX" type="text" value="<%=userDetail.getFAX()%>">	
						<br><font size=2 color=red><%=registerService.getErrorMsg("FAX")%></font>	
					</tr>		
					
					<tr>
						<td align="left">Email:</td>
						<td align="Right"> <input name="Email" type="text" value="<%=userDetail.getEmail()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("Email")%></font>		
					</tr>
						
					<tr>
						<td align="left">Requested Rank:</td>
						<td align="Right"> <input name="rank" type="text" value="<%=userDetail.getRank()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("rank")%></font>		
					</tr>
						
						
					<tr>
						<td align="left">User Name:</td>
						<td align="Right"> <input name="userName" type="text" value="<%=userDetail.getUserName()%>">
						<br><font size=2 color=red><%=registerService.getErrorMsg("userName1")%></font>
						<br><font size=2 color=red><%=registerService.getErrorMsg("userName2")%></font>		
					</tr>
					
					
					<tr>
						<td align="left">Password:</td>
						<td align="Right"> <input name="passWord" type="text" value="">
						<br><font size=2 color=red><%=registerService.getErrorMsg("password")%></font>
					<tr>
						<td align="left">Confirm Password:</td>
						<td align="Right"> <input name="confirmPassword" type="text" value="">
						<br><font size=2 color=red><%=registerService.getErrorMsg("confirmPassword")%></font>		
					</tr>		
					
					<tr>
						<td align="center"><input type="submit">
					</tr>
					 		
				</table>
			
			</form>
		</div>
	</center>
	



	
</body>


</html>