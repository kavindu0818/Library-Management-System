package org.example.bo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.bo.BookHandOverBo;
import org.example.dao.BookDao;
import org.example.dao.BookHandOverDao;
import org.example.dao.Custome.DAOFactory;
import org.example.dao.impl.BookHandOverDaoimpl;
import org.example.dto.BookHandOverDto;

import java.util.ArrayList;
import java.util.List;

public class BookHandOverimpl implements BookHandOverBo {


      //  private BookHandOverDaoimpl bookHandOverDaoimpl = new BookHandOverDaoimpl();
    BookHandOverDao bookHandOverDaoimpl = (BookHandOverDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKHANDOVER);

        public boolean BookingHandSave(BookHandOverDto booking, User user) {

            BookHandOver bookHandOver = new BookHandOver(booking.getId(), booking.getTitle(), booking.getAutour(), booking.getBookingDate(), booking.getHandOverDate(), user);
            boolean isSave = bookHandOverDaoimpl.save(bookHandOver);
            return isSave;
        }

    @Override
    public User getUserByPhoneNumber(int phoneNumber) {
        return null;
    }

//        public User getUserByPhoneNumber(int phoneNumber) {
//
//                return entityManager.createQuery("SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber", User.class)
//                        .setParameter("phoneNumber", phoneNumber)
//                        .getSingleResult();
//
//        }

    public List<BookHandOverDto> getAllHandOverBook() {
            List<BookHandOver> bookHandOvers = bookHandOverDaoimpl.getAllHandOverBook();
            List<BookHandOverDto> bookHandOverDtos = new ArrayList<>();

            for (BookHandOver bookHandOver : bookHandOvers){
                bookHandOverDtos.add(new BookHandOverDto(bookHandOver.getId(),bookHandOver.getTitle(),bookHandOver.getAutour(),bookHandOver.getBookingDate(),bookHandOver.getHandOverDate(),bookHandOver.getCusID().getPhoneNumber()));
            }

            return bookHandOverDtos;
    }

    public boolean deleteBooking(String bookId) {
            boolean isDelete = bookHandOverDaoimpl.delete(bookId);
            return isDelete;
    }

    @Override
    public int getBookingCount() {
        int set = bookHandOverDaoimpl.getBookingCount();
        return set;
    }
}



