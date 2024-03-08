package org.example.dao.impl;

import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookHandOverDaoimpl {

    public boolean save(BookHandOver bookHandOver) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(bookHandOver);

        transaction.commit();
        session.close();

        return true;
    }


}
