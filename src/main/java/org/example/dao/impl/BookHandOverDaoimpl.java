package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookHandOverDaoimpl {

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
        List<BookHandOver>  resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }
}
