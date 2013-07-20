package org.svoptic.service;

import java.util.Hashtable;

import org.svoptic.dto.UserDetail;
import org.svoptic.hibernate.HibernateUtil;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class RegisterService {
	
	
		private Hashtable<String, String> errors = new Hashtable<String, String>();
		   public boolean register(UserDetail user, String repeatPassword){
			   	
			   	boolean allOK = true ;
			   	
		        if(isUserExists(user)){
		        	errors.put("userName1", "an account with the same userName exists");
		            allOK = false ;    
		        }
		        if(user.getUserName().equals("")){
		        	errors.put("userName2","please enter your user name");
		        }
		        if(!isSamePasswords(user, repeatPassword)){
		        	errors.put("confirmPassword","your passwords dosent match");
		        	allOK = false ;
		        }
		        if(user.getFirstName().equals("")){
		        	errors.put("firstName", "please enter your first name");
		        	allOK = false ;
		        }
		        if(user.getLastName().equals("")){
		        	errors.put("lastName", "please enter your last name");
		        	allOK = false ;
		        }
		        if(user.getCity().equals("")){
		        	errors.put("city", "please enter your city name");
		        	allOK = false;
		        }
		        if(user.getCompany().equals("")){
		        	errors.put("company","please enter your company name");
		        	allOK = false;
		        }
		        if(user.getCountry().equals("")){
		        	errors.put("country", "please enter your country name");
		        	allOK = false ;
		        }
		        if(user.getEmail().equals("") || user.getEmail().indexOf("@") == -1){
		        	errors.put("Email","please enter a valid Email address");
		        	allOK = false ;
		        }
		        if(user.getFAX().equals("")){
		        	errors.put("FAX","please enter your FAX number");
		        	allOK = false ;
		        }
		        if(user.getPhone().equals("")){
		        	errors.put("phone", "please enter your phone number");
		        	allOK = false ;
		        }
		        if(user.getPostalCode().equals("")){
		        	errors.put("postalCode","please enter your postal code");
		        	allOK = false ;
		        }
		        if(user.getFirstAddr().equals("")){
		        	errors.put("firstAddr", "please enter your first address");
		        	allOK = false ;
		        }
		        if(user.getSecondAddr().equals("")){
		        	errors.put("secondAddr","please enter your second address");
		        	allOK = false ;
		        }
		        if(user.getProvince().equals("")){
		        	errors.put("province", "please enter your province name");
		        	allOK = false ;
		        }
		        if(user.getRank().equals("")){
		        	errors.put("rank", "please enter your requested rank");
		        	allOK = false ;
		        }
		        if(user.getPassWord().length() < 6){
		        	errors.put("password", "your password length should be greater than 6 character");
		        	allOK = false ;
		        }
		        Transaction tx = null;
		        if(allOK == false)
		        {
		        	//session.close();
		        	return false;
		        }else{
		        	Session session = HibernateUtil.openSession();
			        try {
			            tx = session.getTransaction();
			            tx.begin();
			            session.saveOrUpdate(user);            
			            tx.commit();
			        } catch (Exception e) {
			            if (tx != null) {
			                tx.rollback();
			            }
			            e.printStackTrace();
			        } finally {
			            session.close();
			        }
		        }
		        return true;
		    }
		   
		    
		    public boolean isUserExists(UserDetail user){
		    	boolean result = false;
		        Transaction tx = null; 
		    
		    	Session session = HibernateUtil.openSession();
		    	try
		    	{
			    	tx = session.getTransaction();
			    	tx.begin();
			    	Query query = session.createQuery("from UserDetail where userName='"+user.getUserName()+"'");
			    	UserDetail u = (UserDetail)query.uniqueResult();
			    	if(u!=null) 
			    		result = true;
			    	else
			    		result =  false;
			    	tx.commit();
		    	}catch(Exception e)
		    	{
		    		if(tx != null)
		    			tx.rollback();
		    		
		    		e.printStackTrace();
		    		
		    	}
		    	session.close();
		    	return result;
		    }
	
		    public boolean isSamePasswords(UserDetail user,String repeatedPassword){
		    	
		    	return user.getPassWord().equals(repeatedPassword) ;
		    }
		    
			public String getErrorMsg(String s) {
				String errorMsg =(String)errors.get(s.trim());
			      return (errorMsg == null) ? "":errorMsg;
			}

		    

}
