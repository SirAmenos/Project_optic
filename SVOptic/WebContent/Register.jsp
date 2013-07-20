<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Register Page</title>
</head>
<body>
	<center>
        <div id="mystyle" class="myform">
			<form action="RegisterServlet" method="post">
				<table>
					<tr>
						<td align="left">First Name:</td>
						<td align="Right"> <input name="firstName" type="text" value="">
					</tr>
				
					<tr>
						<td align="left">Last Name:</td>
						<td align="Right"> <input name="lastName" type="text" value="">		
					</tr>
					
					<tr>
						<td align="left">Company:</td>
						<td align="Right"> <input name="company" type="text" value="">		
					</tr>
				
					<tr>
						<td align="left">Addres 1:</td>
						<td align="Right"> <input name="firstAddr" type="text" value="">		
					</tr>
						
					<tr>
						<td align="left">Addres 2:</td>
						<td align="Right"> <input name="secondAddr" type="text" value="">		
					</tr>
						
					<tr>
						<td align="left">City:</td>
						<td align="Right"> <input name="city" type="text" value="">		
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
						<td align="Right"> <input name="postalCode" type="text" value="">		
					</tr>		
			
					<tr>
						<td align="left">Phone:</td>
						<td align="Right"> <input name="phone" type="text" value="">		
					</tr>
					
					
					<tr>
						<td align="left">FAX:</td>
						<td align="Right"> <input name="FAX" type="text" value="">		
					</tr>		
					
					<tr>
						<td align="left">Email:</td>
						<td align="Right"> <input name="Email" type="text" value="">		
					</tr>
						
					<tr>
						<td align="left">Requested Rank:</td>
						<td align="Right"> <input name="rank" type="text" value="">		
					</tr>
						
						
					<tr>
						<td align="left">User Name:</td>
						<td align="Right"> <input name="userName" type="text" value="">		
					</tr>
					
					
					<tr>
						<td align="left">Password:</td>
						<td align="Right"> <input name="passWord" type="text" value="">
					<tr>
						<td align="left">Confirm Password:</td>
						<td align="Right"> <input name="confirmPassword" type="text" value="">		
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