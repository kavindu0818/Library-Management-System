package org.example.dao;

import org.example.Entity.User;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.Custome.SuperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface UserDao extends SuperDao {
    public boolean save(User user);
    public List<User> getAll(String pas);

    public User getUser(int id);


    public boolean update(User user);
    public boolean delete(int phone);

    public List<User> getAllSearchUserDetails(int phoneNumber);

    public List<User> getAllSearchUserDetailsAll();
}
