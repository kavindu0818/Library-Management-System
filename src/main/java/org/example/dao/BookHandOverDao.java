package org.example.dao;

import org.example.Entity.BookHandOver;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.Custome.SuperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface BookHandOverDao extends SuperDao {

    public boolean save(BookHandOver bookHandOver);


    public List<BookHandOver> getAllHandOverBook();

    public boolean delete(String bookId);

    int getBookingCount();
}
