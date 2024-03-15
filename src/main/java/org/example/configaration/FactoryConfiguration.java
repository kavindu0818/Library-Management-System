package org.example.configaration;

import org.example.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("/hibernate.properties"));
        } catch (Exception ignored) {

        }

        Configuration configuration = new Configuration().mergeProperties(properties)
                .addAnnotatedClass(Book.class).addAnnotatedClass(Branch.class).addAnnotatedClass(User.class).addAnnotatedClass(BookHandOver.class).addAnnotatedClass(History.class);

        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ?
                factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
