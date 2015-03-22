package com.pst.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	public static Logger logger = Logger.getLogger("HibernateUtil");

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	
        	// Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration = configuration.configure();
        	
        	ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
        	registryBuilder.applySettings(configuration.getProperties());
            return configuration.buildSessionFactory(registryBuilder.buildServiceRegistry());

            //code that will work with 4.3.x 
        	//Configuration configuration = new Configuration();
        	//configuration.configure();
        	
        	//ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
        	//registryBuilder.applySettings(configuration.getProperties());
        	//StandardServiceRegistry registry = registryBuilder.build();
        	
        	//SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
            //return sessionFactory;
        }
        catch (Throwable ex) {
        	logger.log(Level.SEVERE, "Initial SessionFactory creation failed.", ex);
            throw new RuntimeException(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}