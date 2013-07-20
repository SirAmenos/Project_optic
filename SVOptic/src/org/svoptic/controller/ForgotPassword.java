package org.svoptic.controller;

import java.io.IOException;


import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.svoptic.dto.UserDetail;
import org.svoptic.service.LoginService;
import org.svoptic.service.SendMail;




@WebServlet(name = "ForgotPassword", urlPatterns = {"/ForgotPassword"})
public class ForgotPassword extends HttpServlet {
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {        
        String userId = request.getParameter("userId");        
        LoginService loginService = new LoginService();
        UserDetail user = loginService.getUserByUserId(userId);
        String userMail = user.getEmail();
        String[] mails = new String[1];
        mails[0] = userMail;
        String message = new String();
        String password = user.getPassWord();
        message = "Hi " + user.getFirstName() + "\n" 
        + "your user name is: " + userId + "\n"
        + "your password is: " + password + "\n";
        try {
        	SendMail sendMail = new SendMail();
        	System.out.println(userMail);
			sendMail.send(mails, "forgotten Password", message, "lrzmjd18@gmail.com");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("MailSent.jsp");
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
