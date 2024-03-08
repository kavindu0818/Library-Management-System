package org.example.bo.impl;

import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.dao.impl.BookHandOverDaoimpl;
import org.example.dto.BookHandOverDto;

public class BookHandOverimpl {

    BookHandOverDaoimpl bookHandOverDaoimpl = new BookHandOverDaoimpl();
    public boolean BookingHandSave(BookHandOverDto booking) {
        User user = getUserByPhoneNumber(booking.getCusID());

        User user1 = new User();
        user1.setPhoneNumber(booking.getCusID());

        BookHandOver bookHandOver = new BookHandOver(booking.getId(),booking.getTitle(),booking.getAutour(),booking.getCatougery(),booking.getStatus(),user1);
        boolean isSave = bookHandOverDaoimpl.save(bookHandOver);
        return isSave;
    }

    private User getUserByPhoneNumber(int id){
        return getUserByPhoneNumber(id);
    }

    }

