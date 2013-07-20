package org.svoptic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projection;
import org.svoptic.dto.Order;
import org.svoptic.dto.StockLens;
import org.svoptic.dto.UserDetail;
import org.svoptic.hibernate.HibernateUtil;



public class OrderService {
	
	public List<Order> getAllOrders(){
	       List<Order> list = new ArrayList<Order>();
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;        
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from Order").list();                        
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
	
	
	public List<Order> getStocksforUser(int userId){
		Session session = HibernateUtil.openSession();
		List<Order> list = new ArrayList<Order>();
        Transaction tx = null;
        
        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Order where costumer_id='"+Integer.toString(userId)+"'").list();                       
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
	
	public List<StockLens> getStocks( String index, String manufacturer, String category , String diameter ){
		Session session = HibernateUtil.openSession();
		List<StockLens> list = new ArrayList<StockLens>();
		
		Criteria criteria = session.createCriteria(StockLens.class);
		if(index != null)
			criteria.add(Restrictions.eq("index", index));
		if(manufacturer != null)
			criteria.add(Restrictions.eq("manufacturer", manufacturer));
		if(category != null)
			criteria.add(Restrictions.eq("category", category));
		if(diameter != null)
			criteria.add(Restrictions.eq("diameter", diameter));
    
		list = criteria.list();
		
		session.close();
		return list;
		
		
	}
	
	public StockLens getStockById(int stockId){
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(StockLens.class);
		criteria.add(Restrictions.eq("stockId", stockId));
		StockLens stockLens = (StockLens) criteria.uniqueResult();
		session.close();
		return stockLens;
	}

	
	public boolean AddtoCart(UserDetail costumer , StockLens product){
		
		Order order = new Order("new Order", costumer, product, new Date(), null, "someWhat");
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;
	    try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(order);            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    
		
		return true ;
	}
	
	public void deleteOrderById(int Id){
		
		Session session = HibernateUtil.openSession();
		session.getTransaction().begin();
		Order order = (Order) session.get(Order.class , Id );
		session.delete(order);
		session.getTransaction().commit();
		session.close();

	}
	
	public void editOrderById(int Id , String Number){
		Session session = HibernateUtil.openSession();
		session.getTransaction().begin();
		Order order = (Order) session.get(Order.class , Id );
		order.setNumber(Number);
		session.saveOrUpdate(order);
		session.getTransaction().commit();
		session.close();

	}
	
	public void changeState(int Id , String changeValue){
		Session session = HibernateUtil.openSession();
		session.getTransaction().begin();
		Order order = (Order) session.get(Order.class , Id );
		order.setState(changeValue);
		session.saveOrUpdate(order);
		session.getTransaction().commit();
		session.close();


	}
	
	public List getUserEmails(){
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(UserDetail.class);
		Projection p1 = Projections.property("EMAIL");
		criteria.setProjection(p1);
		List list = criteria.list();
		session.close();
		return list;
		
	}
}
