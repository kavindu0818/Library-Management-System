package org.example.bo.impl;

import org.example.Entity.Book;
import org.example.Entity.User;
import org.example.bo.UserBo;
import org.example.dao.BranchDao;
import org.example.dao.Custome.DAOFactory;
import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoimpl;
import org.example.dto.BookDto;
import org.example.dto.HistoryDto;
import org.example.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserBoimpl implements UserBo {

    UserDaoimpl userDaoimpl =new UserDaoimpl();

    UserDao branchDaoimpl = (UserDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    public boolean userSave(UserDto us) {

        User user = new User(us.getPhoneNumber(), us.getFullName(), us.getUserName(), us.getPassword(), us.getGmail());
        return userDaoimpl.save(user);
    }

    public List<UserDto> getAllUser(String pas) {


        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDaoimpl.getAll(pas);


        for (User user1 : users) {
            userDtos.add(new UserDto(user1.getPhoneNumber(),user1.getFullName(),user1.getUserName(),user1.getPassword(),user1.getGmail()));
        }

        return userDtos;
    }

    public UserDto getUser(int id) {

        User user = userDaoimpl.getUser(id);
        UserDto userDto = new UserDto(user.getPhoneNumber(),user.getFullName(),user.getUserName(),user.getPassword(),user.getGmail());

      return userDto;
    }

    public boolean userUpdate(UserDto user) {
        User userDto = new User(user.getPhoneNumber(),user.getFullName(),user.getUserName(),user.getPassword(),user.getGmail());
        boolean isUpdte = userDaoimpl.update(userDto);
        return isUpdte;
    }

    public boolean userDelete(int phone) {
        boolean isDelete = userDaoimpl.delete(phone);
        return isDelete;
    }

    public List<UserDto> getSearchUser(int user) {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDaoimpl.getAllSearchUserDetails(user);


        for (User user1 : users) {
            userDtos.add(new UserDto(user1.getPhoneNumber(),user1.getFullName(),user1.getUserName(),user1.getPassword(),user1.getGmail()));
        }

        return userDtos;
    }

    public List<UserDto> getAllUserAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDaoimpl.getAllSearchUserDetailsAll();


        for (User user1 : users) {
            userDtos.add(new UserDto(user1.getPhoneNumber(),user1.getFullName(),user1.getUserName(),user1.getPassword(),user1.getGmail()));
        }

        return userDtos;
    }

    @Override
    public int getUserCount() {
        int set = userDaoimpl.getUserCount();
        return set;
    }

    @Override
    public boolean setUpdate(UserDto us) {
        User user = new User(us.getPhoneNumber(),us.getFullName(),us.getUserName(),us.getPassword(),us.getGmail());
        boolean isUpdate = userDaoimpl.update(user);
        return isUpdate;
    }

    @Override
    public List<UserDto> getSearchUserUpdate(String userName) {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDaoimpl.getAllSearchUserDetailsUpdate(userName);


        for (User user1 : users) {
            userDtos.add(new UserDto(user1.getPhoneNumber(),user1.getFullName(),user1.getUserName(),user1.getPassword(),user1.getGmail()));
        }

        return userDtos;
    }

}
