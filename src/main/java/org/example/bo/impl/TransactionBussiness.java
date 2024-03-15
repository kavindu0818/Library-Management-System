package org.example.bo.impl;

import org.example.Entity.BookHandOver;
import org.example.Entity.History;
import org.example.configaration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionBussiness {

    public void sendTransaction(String bookId, String title, String uId, String bookD, String booKH) {

        try{

           boolean isDelete = deleteBooking(bookId);

           if (isDelete){
               String id = "00001";
               History history = new History(id,bookId,title,bookD,booKH,uId);
              boolean isSave = saveBookingHistory(history);
           }else{
               System.out.println("Not Add");
           }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private boolean saveBookingHistory(History history) {
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
}
