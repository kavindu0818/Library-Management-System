package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.BookDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDaoimpl implements BookDao {
    public boolean save(Book book1) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(book1);

        transaction.commit();
        session.close();

        return true;

    }

    public List<Book> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Book> query = session.createQuery("FROM Book", Book.class);
        List<Book>  resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    public List<Book> getAllSearchBookDetails(String book) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Book> query = session.createQuery("FROM Book WHERE title LIKE :bookTitle", Book.class);
        query.setParameter("bookTitle", "%" + book + "%");

        List<Book> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;

    }

    public boolean DeleteBook(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book bookToDelete = session.get(Book.class, id);


        session.delete(bookToDelete);

        transaction.commit();
        session.close();

        return true;
    }

    public boolean update(Book book) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(book);

        transaction.commit();
        session.close();

        return true;
    }

    public String getLastBookId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        Query<String> query = session.createQuery(
                "SELECT b.id FROM Book b ORDER BY b.id DESC", String.class
        );
        query.setMaxResults(1);
        String latestBookId = query.uniqueResult();
        return latestBookId;
    }

    @Override
    public int getBookCount() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Long> countQuery = session.createQuery("SELECT COUNT(*) FROM Book", Long.class);

        Long bookCount = countQuery.uniqueResult(); // Get the count of books matching the query

        transaction.commit();
        session.close();

        // Handle null value
        return bookCount != null ? bookCount.intValue() : 0;
    }



}
