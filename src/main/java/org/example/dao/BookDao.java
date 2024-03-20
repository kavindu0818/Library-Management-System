package org.example.dao;

import org.example.Entity.Book;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.Custome.SuperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface BookDao extends SuperDao {

    public boolean save(Book book1);

    public List<Book> getAll();
    public List<Book> getAllSearchBookDetails(String book);

    public boolean DeleteBook(String id);

    public boolean update(Book book);

    public String getLastBookId();


    int getBookCount();
}
