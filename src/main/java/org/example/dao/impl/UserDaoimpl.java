package org.example.dao.impl;

import jakarta.persistence.NoResultException;
import org.example.Entity.Book;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.UserDao;
import org.example.dto.UserDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoimpl implements UserDao {
    public boolean save(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

        return true;
    }

    public List<User> getAll(String pas) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE userName LIKE :pas", User.class);
        query.setParameter("pas", "%" + pas + "%");


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

    public List<User> getAllSearchUserDetails(int phonenumber) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE phoneNumber = :phonenumber", User.class);
        query.setParameter("phonenumber", + phonenumber );


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

    public int getUserCount() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Long> countQuery = session.createQuery("SELECT COUNT(*) FROM User", Long.class);

        Long bookCount = countQuery.uniqueResult(); // Get the count of books matching the query

        transaction.commit();
        session.close();

        // Handle null value
        return bookCount != null ? bookCount.intValue() : 0;
    }

    public List<User> getAllSearchUserDetailsUpdate(String username) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // Corrected named parameter to match with the query
        Query<User> query = session.createQuery("FROM User WHERE userName LIKE :username", User.class);

        // Concatenate the wildcard with the parameter value before setting it
        query.setParameter("username", "%" + username + "%");

        List<User> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }
}
