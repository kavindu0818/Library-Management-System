package org.example.dao.impl;

import org.example.Entity.Book;
import org.example.Entity.Branch;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.BranchDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BranchDaoimpl implements BranchDao {
    public boolean branchSave(Branch branch1) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(branch1);

        transaction.commit();
        session.close();

        return true;
    }

    public List<Branch> getAllBranches() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Branch> query = session.createQuery("FROM Branch ", Branch.class);
        List<Branch>  resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    public List<Branch> getSearchBranch(String branchName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Branch> query = session.createQuery("FROM Branch WHERE branchName LIKE :brancname", Branch.class);
        query.setParameter("brancname", "%" + branchName + "%");  // Use the correct parameter name

        List<Branch> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    public boolean update(Branch branch1) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(branch1);

        transaction.commit();
        session.close();

        return true;
    }

    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Branch branch = session.get(Branch.class,id);

        session.delete(branch);

        transaction.commit();
        session.close();

        return true;
    }

    public String getLastBookId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        Query<String> query = session.createQuery(
                "SELECT b.id FROM Branch b ORDER BY b.id DESC", String.class
        );
        query.setMaxResults(1);
        String latestBookId = query.uniqueResult();
        return latestBookId;

    }

    @Override
    public int getCount() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Long> countQuery = session.createQuery("SELECT COUNT(*) FROM Branch", Long.class);

        Long bookCount = countQuery.uniqueResult(); // Get the count of books matching the query

        transaction.commit();
        session.close();

        // Handle null value
        return bookCount != null ? bookCount.intValue() : 0;
    }
}
