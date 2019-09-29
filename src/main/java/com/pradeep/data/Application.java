package com.pradeep.data;

import java.util.Date;
import java.util.Properties;

import com.pradeep.data.entities.AccountType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}
}
