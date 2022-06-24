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
    	
    	AlienName an = new AlienName();
    	an.setFname("Ari");
    	an.setMname("karan");
    	an.setLname("Sivasankar");
       Alien a = new Alien();
       a.setAid(107);
       a.setAname(an);
       a.setColour("red");
       
       Configuration c = new Configuration().configure().addAnnotatedClass(Alien.class);
       ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
       SessionFactory sf = c.buildSessionFactory(sr); 
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
      // session.save(a); // it will save the data into database
      // Alien a1 = (Alien)session.get(Alien.class, 105);//using id , we fetching
       // this get method will return obj ref so typecast to Alien
       session.save(a);
       tx.commit();
      
    }
}
