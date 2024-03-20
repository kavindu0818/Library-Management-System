package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.BookHandOverDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookHandOverDaoimpl implements BookHandOverDao {

    public boolean save(BookHandOver bookHandOver) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(bookHandOver);

        transaction.commit();
        session.close();

        return true;
    }


    public List<BookHandOver> getAllHandOverBook() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<BookHandOver> query = session.createQuery("FROM BookHandOver ", BookHandOver.class);
      //  query.setParameter("userid",  + userid );
        List<BookHandOver>  resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    public boolean delete(String bookId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        BookHandOver bookToDelete = session.get(BookHandOver.class, bookId);


        session.delete(bookToDelete);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public int getBookingCount() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Long> countQuery = session.createQuery("SELECT COUNT(*) FROM BookHandOver", Long.class);

        Long bookCount = countQuery.uniqueResult(); // Get the count of books matching the query

        transaction.commit();
        session.close();

        // Handle null value
        return bookCount != null ? bookCount.intValue() : 0;
    }
}
