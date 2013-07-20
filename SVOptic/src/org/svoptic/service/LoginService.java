package org.svoptic.service;

import org.svoptic.dto.UserDetail;
import org.svoptic.hibernate.HibernateUtil;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



import java.util.ArrayList;
import java.util.List;

public class LoginService {
	
	
	private String error = "" ;
    public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean authenticate(String userId, String password) {
        UserDetail user = getUserByUserId(userId);
        if(user!=null && user.getUserName().equals(userId) && user.getPassWord().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }

    public UserDetail getUserByUserId(String userId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        UserDetail user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from UserDetail where userName='"+userId+"'");
            user = (UserDetail)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    
    public List<UserDetail> getListOfUsers(){
        List<UserDetail> list = new ArrayList<UserDetail>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from UserDetail").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
    
   
}
