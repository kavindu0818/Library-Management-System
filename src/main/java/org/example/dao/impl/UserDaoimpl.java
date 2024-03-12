package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.example.dto.UserDto;
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

    public User getUser(int id) {
//        int primryId = Integer.parseInt(id);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM User WHERE phoneNumber = :phoneNumber", User.class);
            query.setParameter("phoneNumber", id);

            User user = (User) query.uniqueResult();

            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception appropriately
        } finally {
            session.close();
        }

        return null;
    }


    public boolean update(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();

        return true;
    }

    public boolean delete(int phone) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User userToDelete = session.get(User.class, phone);


        session.delete(userToDelete);

        transaction.commit();
        session.close();

        return true;
    }

    public List<User> getAllSearchUserDetails(int phoneNumber) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE phoneNumber = :phoneNumber", User.class);
        query.setParameter("phoneNumber", phoneNumber);

        List<User> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    public List<User> getAllSearchUserDetailsAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User ", User.class);
        List<User>  resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }
}
