package org.example.dao.impl;

import org.example.Entity.History;
import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HistoryDaoimpl {
    public List<History> getAllHistory() {

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            Query<History> query = session.createQuery("FROM History ", History.class);
            List<History>  resultList = query.getResultList();

            transaction.commit();
            session.close();
            return resultList;
        }


}
