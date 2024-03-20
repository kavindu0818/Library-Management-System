package org.example.bo;

import org.example.Entity.BookHandOver;
import org.example.Entity.User;
import org.example.bo.Custome.SuperBo;
import org.example.dto.BookHandOverDto;

import java.util.ArrayList;
import java.util.List;

public interface BookHandOverBo extends SuperBo {
    public boolean BookingHandSave(BookHandOverDto booking, User user);

     User getUserByPhoneNumber(int phoneNumber);

    public List<BookHandOverDto> getAllHandOverBook();

    public boolean deleteBooking(String bookId);

    int getBookingCount();
}
