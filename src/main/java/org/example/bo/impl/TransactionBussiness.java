package org.example.bo.impl;

import org.example.Entity.BookHandOver;
import org.example.Entity.History;
import org.example.configaration.FactoryConfiguration;
import org.example.dao.Custome.DAOFactory;
import org.example.dao.impl.HistoryDaoimpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionBussiness implements org.example.bo.Transaction {

    org.example.dao.History historyDaoimpl = (org.example.dao.History) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.HISTORY);

    public void sendTransaction(String bookId, String title, String uId, String bookD, String booKH, String bookingId) {

        try{

           boolean isDelete = deleteBooking(bookId);

           if (isDelete){
               History history = new History(bookingId,bookId,title,bookD,booKH,uId);
              boolean isSave = saveBookingHistory(history);
           }else{
               System.out.println("Not Add");
           }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendTransaction(String bookId, String title, String uId, String bookD, String booKH) {

    }

    public boolean saveBookingHistory(History history) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(history);

        transaction.commit();
        session.close();

        return true;
    }

    public boolean deleteBooking(String bookId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        BookHandOver bookToDelete = session.get(BookHandOver.class, bookId);


        session.delete(bookToDelete);

        transaction.commit();
        session.close();

        return true;
    }
    public String getLastBranchId() {
        return historyDaoimpl.getLastBookingId();
    }
}
