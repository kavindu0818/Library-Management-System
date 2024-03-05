package org.example.dao;

import org.example.Entity.Branch;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BranchDaoimpl {
    public boolean branchSave(Branch branch1) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(branch1);

        transaction.commit();
        session.close();

        return true;
    }
}
