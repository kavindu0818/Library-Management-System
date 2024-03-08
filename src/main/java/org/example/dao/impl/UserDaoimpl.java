package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoimpl {
    public boolean save(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

        return true;
    }

    public List<User> getAll(String pas, String userName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE password LIKE :password AND userName LIKE :userName", User.class);
        query.setParameter("password", "%" + pas + "%");
        query.setParameter("userName", "%" + userName + "%");

        List<User> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }
}
