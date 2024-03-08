package org.example.bo.impl;

import org.example.Entity.User;
import org.example.dao.impl.UserDaoimpl;
import org.example.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserBoimpl {

    UserDaoimpl userDaoimpl =new UserDaoimpl();

    public boolean userSave(UserDto us) {

        User user = new User(us.getPhoneNumber(),us.getFullName(),us.getUserName(),us.getPassword(),us.getGmail());
        boolean isSave = userDaoimpl.save(user);
        return isSave;
    }

    public List<UserDto> getAllUser(String pas, String userName) {
        List<UserDto> userList = new ArrayList<>();
        List<User> users = userDaoimpl.getAll(pas, userName);

        for (User user: users){
            userList.add(new UserDto(user.getPhoneNumber(),user.getFullName(),user.getUserName(),user.getPassword(),user.getGmail()));
        }
        return userList;
    }
}
