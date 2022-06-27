package com.arikaran.Demohib3;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HQLDemo4 {
	public static void main(String[]args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Employee1.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		SQLQuery sq = s.createSQLQuery("Select * from Employee1");
		sq.addEntity(Employee1.class);
		List<Employee1> ll = sq.list();
		for(Employee1 i : ll) {
			System.out.println(i);
		}
		SQLQuery sq1 = s.createSQLQuery("select * from Employee1 where id =13");
		sq1.addEntity(Employee1.class);
		
		Employee1 i =(Employee1) sq1.uniqueResult();
		System.out.println(i);
		
	}

}
