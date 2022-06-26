package com.arikaran.Demohib3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Employee e1 = new Employee();
    	e1.setId(5);
    	e1.setName("Natasha");
    	
    	
       
       
       Configuration c = new Configuration().configure().addAnnotatedClass(Employee.class);
       
       
       ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
       
       
       SessionFactory sf = c.buildSessionFactory(sr);
       
       Session session1 = sf.openSession();
       
       Transaction tx = session1.beginTransaction();
      
      Employee emp1 = (Employee)session1.get(Employee.class, 1);
    System.out.println("Fetching 1st time: "+emp1); // fetching first time		
    session1.getTransaction().commit();
    
    session1.close();
    
    
    Session session2 = sf.openSession();
    
    Transaction tx1 = session2.beginTransaction();
    
    Employee emp2 = (Employee)session2.get(Employee.class, 1);
    
    System.out.println("Fetching 2nd time: "+emp2);	//fetching 2nd time using diff session
    session2.getTransaction().commit();
    
    session2.close();
      
       // we are fetching same data for 2 times and its hitting the database for 2 times to fetch
    // the same value because each session has :
                     // first level catch and sescond level cache
    // so first it will check the req value in first and second lvel if not there it 
    // hitting the data base to fetch the req value  
      
       
      
    }
}
