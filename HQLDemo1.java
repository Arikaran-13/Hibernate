package com.arikaran.Demohib3;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HQLDemo1 {
	public static void main(String[]args) {
		
		Configuration c = new Configuration().configure().addAnnotatedClass(Employee1.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
		
		SessionFactory sf =c.buildSessionFactory(reg);
		
		Session s =sf.openSession();
		
		Transaction tx = s.beginTransaction();
		/*
		 * Random r = new Random(); 
		 * for(int i=1;i<=50;i++) 
		 * { Employee1 e = new
		 * Employee1(); e.setId(i); e.setName("Name"+i); e.setSal(r.nextInt(10000));
		 * s.save(e); }
		 */
		Query q1 = s.createQuery("from Employee1");
		List<Employee1> l = q1.list();
		for(Employee1 i : l) {
			System.out.println(i);
			
		}
		System.out.println("____________________");
		
		Query q2 = s.createQuery("from Employee1 where sal>9000");
		List<Employee1> l1 = q2.list();
		for(Employee1 i:l1 ) {
			System.out.println(i);
		}
		System.out.println("---------------------");
		Query q3 = s.createQuery("from Employee1 where id=13");
		Employee1 res = (Employee1)q3.uniqueResult();
		System.out.println(res);
		tx.commit();
		s.close();
		
	}

}
