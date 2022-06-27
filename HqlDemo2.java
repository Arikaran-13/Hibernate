package com.arikaran.Demohib3;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HqlDemo2 {
	public static void main(String[]args) {
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee1.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Query q1 = s.createQuery(" select id,name from Employee1");
		List<Object[]> eobj = (List<Object[]>)q1.list();
		for(Object[] i : eobj) {
			System.out.println(i[0]+" : "+i[1]);
		}
		System.out.println("------------------");
		Query q2 = s.createQuery(" select id,name from Employee1 e where e.id=1");
		List<Object[]>emp = (List<Object[]>)q1.list();
		for(Object[] i : emp) {
			System.out.println(i[0]+" : "+i[1]);
		}
		System.out.println("-------------------");
		int b=5000;
		Query q3 = s.createQuery("select sum(sal) from Employee1  where  sal> :b");
		q3.setParameter("b", b); // we are setting the b value inside our query q3
		Long ans = (Long)q3.uniqueResult(); 
		System.out.println(ans);
		t.commit();
		s.close();
	}

}
