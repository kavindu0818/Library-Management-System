package org.example.dao;

import org.example.Entity.Branch;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.Custome.SuperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface BranchDao extends SuperDao {

    public boolean branchSave(Branch branch1);

    public List<Branch> getAllBranches();

    public List<Branch> getSearchBranch(String branchName);

    public boolean update(Branch branch1);

    public boolean delete(String id);

    public String getLastBookId();

    int getCount();
}
