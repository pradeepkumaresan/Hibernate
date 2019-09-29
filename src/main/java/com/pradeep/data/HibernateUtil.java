package com.pradeep.data;

import com.pradeep.data.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Singleton class for session factory.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * Throw an exception from constructor is reflection is
     * trying to initialize the class.
     * @throws Exception
     */
    private HibernateUtil() throws Exception {
        if(sessionFactory == null)
            throw new Exception();
    }

    /**
     * public thread safe method to build session factory lazily
     * for first time and return same instance subsequent times.
     * @return
     */
    public static SessionFactory getSessionFactory(){
        synchronized (HibernateUtil.class){
            if(sessionFactory == null){
                synchronized (HibernateUtil.class){
                    buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }

    /**
     * private method to build session factory.
     * @return
     */
    private static SessionFactory buildSessionFactory() {
        try{
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            // Don't use no arg constructor for
            // buildSessionFactory.
            sessionFactory = configuration.buildSessionFactory
                            (new StandardServiceRegistryBuilder()
                                    .build());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
