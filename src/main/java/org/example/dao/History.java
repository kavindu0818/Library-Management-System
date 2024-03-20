package org.example.dao;

import org.example.configaration.FactoryConfiguration;
import org.example.dao.Custome.SuperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface History extends SuperDao {

    public List<org.example.Entity.History> getAllHistory();


    public List<org.example.Entity.History> getAllHistoryUser(int uId);

    public String getLastBookingId();
}
