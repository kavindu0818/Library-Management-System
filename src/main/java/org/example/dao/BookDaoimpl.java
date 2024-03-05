package org.example.dao;

import org.example.Entity.Book;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDaoimpl {
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
}
