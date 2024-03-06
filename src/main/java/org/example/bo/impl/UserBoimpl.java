package org.example.bo.impl;

import org.example.Entity.User;
import org.example.dao.impl.UserDaoimpl;
import org.example.dto.UserDto;

public class UserBoimpl {

    UserDaoimpl userDaoimpl =new UserDaoimpl();

    public boolean userSave(UserDto us) {

        User user = new User(us.getPhoneNumber(),us.getFullName(),us.getUserName(),us.getPassword(),us.getGmail());
        boolean isSave = userDaoimpl.save(user);
        return isSave;
    }
}
