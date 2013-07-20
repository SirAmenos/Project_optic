package org.svoptic.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.svoptic.dto.UserDetail;
import org.svoptic.hibernate.HibernateUtil;

public class UpdateService {
    public UserDetail UpdateUserByUserId(String userId, String firstName, String lastName, String city, String country,
    		String province, String phone, String FAX, String Email, String postalCode, String company, String firstAddr,
    		String secondAddr) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        UserDetail user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from UserDetail where userName='"+userId+"'");
            user = (UserDetail)query.uniqueResult();
            user.setCity(city);
            user.setCompany(company);
            user.setCountry(country);
            user.setEmail(Email);
            user.setFAX(FAX);
            user.setFirstAddr(firstAddr);
            user.setSecondAddr(secondAddr);
            user.setProvince(province);
            user.setPhone(phone);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setPostalCode(postalCode);
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
        return user;
    }

}
