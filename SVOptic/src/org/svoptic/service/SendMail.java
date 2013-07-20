package org.svoptic.service;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.*;

public class SendMail
{

	private String strSmtp;

    
    public void setStrSmtp(String strSmtp){
		this.strSmtp=strSmtp;
	  }

	public String getStrSmtp(){
		return this.strSmtp;
	}

	

	public void send( String[] recipients, String subject, String message , final String from) throws MessagingException
	{
		
		 //Set the host smtp address

//		final String username = "lrzmjd18@gmail.com";
		final String password = "3860303929";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				  });
		 
				try {

					Message msg = new MimeMessage(session);


					// set the from and to address
					InternetAddress addressFrom = new InternetAddress(from);
					msg.setFrom(addressFrom);

					InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
					for (int i = 0; i < recipients.length; i++)
					{
						addressTo[i] = new InternetAddress(recipients[i]);
					}
					msg.setRecipients(Message.RecipientType.TO, addressTo);
					
	
					// Setting the Subject and Content Type
					msg.setSubject(subject);
					msg.setContent(message, "text/plain");

					//send message
					Transport.send(msg);		 
					System.out.println("Done");
		 
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
	}
}