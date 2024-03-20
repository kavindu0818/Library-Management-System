package org.example.bo;

import org.example.Entity.BookHandOver;
import org.example.Entity.History;
import org.example.bo.Custome.SuperBo;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;

public interface Transaction extends SuperBo {

    public void sendTransaction(String bookId, String title, String uId, String bookD, String booKH);
    public boolean saveBookingHistory(History history);
    public boolean deleteBooking(String bookId);
    public String getLastBranchId();
}
