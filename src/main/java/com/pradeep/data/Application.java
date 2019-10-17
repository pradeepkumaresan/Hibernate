package com.pradeep.data;

import java.util.Date;
import java.util.Properties;

import com.pradeep.data.entities.AccountType;
import com.pradeep.data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//session.getTransaction().begin();

        User user = getUser();

        session.save(user);
        session.getTransaction().commit();

        session.close();
	}

    private static User getUser() {
        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("kevin");
        user.setCreatedDate(new Date());
        user.setEmailAddress("ullala@yahoo.com");
        user.setFirstName("Kevin");
        user.setLastName("Bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
        return user;
    }
}
