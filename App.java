package com.arikaran.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Student s1 = new Student("Ari",101,"Green");
       Configuration c = new Configuration(); 
       SessionFactory sf = c.buildSessionFactory();
       Session s = sf.openSession();
      s.save(s1); // this data should be saved in the database
    }
}
