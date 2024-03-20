package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.Entity.History;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HistoryDaoimpl implements org.example.dao.History {
    public List<History> getAllHistory() {

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            Query<History> query = session.createQuery("FROM History ", History.class);
            List<History>  resultList = query.getResultList();

            transaction.commit();
            session.close();
            return resultList;
        }


    public List<History> getAllHistoryUser(int uId) {

        String id = String.valueOf(uId);
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<History> query = session.createQuery("FROM History WHERE cusId LIKE :uId", History.class);
        query.setParameter("uId",  + uId );

        List<History> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    public String getLastBookingId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        Query<String> query = session.createQuery(
                "SELECT b.id FROM History b ORDER BY b.id DESC", String.class
        );
        query.setMaxResults(1);
        String latestBookId = query.uniqueResult();
        return latestBookId;
    }
}
