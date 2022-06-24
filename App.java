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
       Alien a = new Alien();
       a.setAid(106);
       a.setAname("jacky");
       a.setColour("green");
       
       Configuration c = new Configuration().configure().addAnnotatedClass(Alien.class);
       ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
       SessionFactory sf = c.buildSessionFactory(sr); 
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
      // session.save(a); // it will save the data into database
       Alien a1 = (Alien)session.get(Alien.class, 106);//using id , we fetching
       // this get method will return obj ref so typecast to Alien
       tx.commit();
       System.out.println(a1);
    }
}
