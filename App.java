package com.arikaran.DemoHib2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Student s1 = new Student();
       s1.setName("ari");
       s1.setId(1);
       s1.setStd(12);
       Configuration c = new Configuration().configure().addAnnotatedClass(Student.class);
       SessionFactory sf =c.buildSessionFactory();
       Session s = sf.openSession();
       Transaction tx = s.beginTransaction();
       s.save(s1);
   tx.commit();
    }
}
