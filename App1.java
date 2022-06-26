package com.arikaran.Demohib3;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class App1 {

	public static void main(String[]args) {
		
		Configuration c = new Configuration().configure().addAnnotatedClass(Employee.class);
				
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = c.buildSessionFactory();
		
		Session s1 = sf.openSession();
		
		Transaction tx = s1.beginTransaction();
		
		Query q1 = s1.createQuery("from Employee where id=1");
		
		q1.setCacheable(true);
		
		Employee e1 =(Employee)q1.uniqueResult();
		
		System.out.println(e1);
		
		tx.commit();
		
		s1.close();
		
		Session s2 = sf.openSession();
		
		Transaction tx1 = s2.beginTransaction();
		
		Query q2 = s2.createQuery("from Employee where id =1");
		
		q2.setCacheable(true);// 
		// instructing the compiler toactivate 2nd level cahing for query too.
		
		Employee e2 = (Employee)q2.uniqueResult();
		
		System.out.println(e2);
		
		tx1.commit();
		
		s2.close();
		// Even though we configurated the second level cache
		//its not working for Query because it only work for get() method
		// to activate the 2nd level cache for query we need add property
		// <property name="hibernate.cache.use_query_cache">true</property>
		// we need query obj q1, q2 to set the cachable to true.
	}
}
