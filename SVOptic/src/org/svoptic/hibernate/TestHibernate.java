package org.svoptic.hibernate;

import java.util.HashSet;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.svoptic.dto.Order;
import org.svoptic.dto.StockLens;
import org.svoptic.dto.UserDetail;
import org.svoptic.service.OrderService;
import org.svoptic.service.SendMail;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		OrderService orderService = new OrderService();
		List emails = orderService.getUserEmails();
		
		/*for(String s : emails)
			System.out.println(s);
		*/
	/*	OrderService orderService = new OrderService();
		UserDetail user = new UserDetail("firstName", "lastName", "company", "firstAddr", "secondAddr", "city",
				"postalCode", "country", "province", "phone", "fAX", "email", "rank", "userName", "passWord", null);
		StockLens product = new StockLens("index", "manufacturer", "diameter", "webPrice", "regPrice", "description", null);
		orderService.AddtoCart(user,product);*/
		
/*	    StockLens stock1 = new StockLens("index" , "maufacturer", "daimaeter", "webPrice", "regPrice", "description", null);
	    StockLens stock2 = new StockLens("index2","manu", "diam", "web", "reg", "desc", null);
	    Session session = HibernateUtil.openSession();
	    session.getTransaction().begin();
		session.save(stock2);
		session.save(stock1);
		session.getTransaction().commit();
		session.close();*/
	/*	
		Session session = HibernateUtil.openSession();
		session.getTransaction().begin();
		Order order = (Order) session.get(Order.class , 1 );
		session.delete(order);
		session.getTransaction().commit();
		session.close();
	    */
		
		/*List <StockLens> list = orderService.getStocks(null, null, null, "diam");
		for(StockLens s : list)
			System.out.println("FFFFFFFFFFF* :" + s.getDescription() );*/
		
		/*OrderService orderService = new OrderService();
		orderService.getStocksforUser(3);*/
/*		UserDetail user2 = new UserDetail("fistName", "lastName", "company", "firstAddr", "secondAddr", "city", "country",
				"province", "postalCode", "phone", "FAX", "Email", "rank", "userName", "passWord", null);
	    StockLens stock2 = new StockLens("index2","manu", "diam", "web", "reg", "desc", null);
	    Order order = new Order( "state", user2, stock2, null, null, null);
	   
		Session session = HibernateUtil.openSession() ;
		session.getTransaction().begin();
		List list = session.createQuery("from Order where costumer_id='"+Integer.toString(1)+"'").list(); 
		session.save(user2);
		session.save(stock2);
		session.save(order);
		session.getTransaction().commit();
		session.close();
		*/
	
		
		
/*		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	    UserDetail user1 = new UserDetail("fistName", "lastName", "company", "firstAddr", "secondAddr", "city", "country",
				"province", "postalCode", "phone", "FAX", "Email", "rank", "userName", "passWord", null);	
	    UserDetail user2 = new UserDetail("alireza", "lastName", "company", "firstAddr", "secondAddr", "city", "country",
				"province", "postalCode", "phone", "FAX", "Email", "rank", "alireza.majidi", "810188393", null);
	    
	    StockLens stock1 = new StockLens("index" , "maufacturer", "daimaeter", "webPrice", "regPrice", "description", null);
	    StockLens stock2 = new StockLens("index2","manu", "diam", "web", "reg", "desc", null);
	    
	    HashSet<UserDetail> users = new HashSet<UserDetail>();
	    users.add(user1);
	    users.add(user2);
	    
	    stock1.setUserDetails(users);
	    stock2.setUserDetails(users);
	    
	    HashSet<StockLens> stocks = new HashSet<StockLens>();
	    stocks.add(stock1);
	    stocks.add(stock2);
	    
	    user1.setStockLenses(stocks);
	    user2.setStockLenses(stocks);
	    
	    Order order = new Order( "state", user1, stock1, null, null, null);

	    Order order2 = new Order( "WAIT", user2, stock2, null, null, null);
	    
	    Order order3 = new Order( "done", user1, stock2, null, null, null);


	    
	    Session session = sessionFactory.openSession();
	    session.getTransaction().begin();
	    
	    session.save(user1);
	    session.save(user2);
	    session.save(stock1);
	    session.save(stock2);
	    session.save(order);
	    session.save(order2);
	    session.save(order3);
		
		session.getTransaction().commit();
		session.close();
		*/
		
	    //Session session = HibernateUtil.openSession();
		//session2.beginTransaction();
	    
	//	Query query = session2.createQuery("from UserDetail where userName='a.majidi'");
	//	UserDetail u = (UserDetail)query.uniqueResult();
	//	if(u == null ) System.out.println("ridi");
		
/*		SendMail sendMail = new SendMail();
		sendMail.setStrSmtp("localhost");
		String[] recipients = new String[2];
		recipients[0] = "lrzmjd18@gmail.com";
		recipients[1] = "alireza.majidi@ymail.com";
		try {
			sendMail.send(recipients, "Hello mail", "Hello world", "lrzmjd18@gmail.com");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


	}

}
