package com.arikaran.Demohib4;

import java.util.ArrayList;
import java.util.List;

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
    	Laptop l1 = new Laptop();
    	l1.setLid(103);
    	l1.setLname("Mac OS");
    List<Laptop> l = new ArrayList<Laptop>();
    l.add(l1);
        Student s1 = new Student(); 
        s1.setId(3);
        s1.setMarks(77);
        s1.setName("kamal");
       s1.setLaptop(l);
        
        Configuration c = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
        SessionFactory sf = c.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction(); 
		/*
		 * session.save(s1); session.save(l1);
		 */
        Student student  = (Student)session.get(Student.class, 1);
        tx.commit();
        System.out.println("Hi");
		/*
		 * List<Laptop>lap = student.getLaptop(); for(Laptop i : lap) {
		 * System.out.println(i); }
		 */
        System.out.println(student);
    }
}
