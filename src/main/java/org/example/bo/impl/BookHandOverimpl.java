package org.example.bo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.dao.impl.BookHandOverDaoimpl;
import org.example.dto.BookHandOverDto;

import java.util.ArrayList;
import java.util.List;

public class BookHandOverimpl {
        @PersistenceContext
        private EntityManager entityManager;

        private BookHandOverDaoimpl bookHandOverDaoimpl = new BookHandOverDaoimpl();

        public boolean BookingHandSave(BookHandOverDto booking, User user) {

            System.out.println(booking.getId() + " " + booking.getTitle() + " " + booking.getAutour() + " " + booking.getAutour()+ "" + user.getPhoneNumber());

            BookHandOver bookHandOver = new BookHandOver(booking.getId(), booking.getTitle(), booking.getAutour(), booking.getBookingDate(), booking.getHandOverDate(), user);
            boolean isSave = bookHandOverDaoimpl.save(bookHandOver);
            return isSave;
        }

        private User getUserByPhoneNumber(int phoneNumber) {
            try {
                return entityManager.createQuery("SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber", User.class)
                        .setParameter("phoneNumber", phoneNumber)
                        .getSingleResult();
            } catch (javax.persistence.NoResultException e) {
                return null;
            }
        }

    public List<BookHandOverDto> getAllHandOverBook() {
            List<BookHandOver> bookHandOvers = bookHandOverDaoimpl.getAllHandOverBook();
            List<BookHandOverDto> bookHandOverDtos = new ArrayList<>();

            for (BookHandOver bookHandOver : bookHandOvers){
                bookHandOverDtos.add(new BookHandOverDto(bookHandOver.getId(),bookHandOver.getTitle(),bookHandOver.getAutour(),bookHandOver.getBookingDate(),bookHandOver.getHandOverDate(),bookHandOver.getCusID().getPhoneNumber()));
            }

            return bookHandOverDtos;
    }
}



