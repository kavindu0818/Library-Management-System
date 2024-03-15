package org.example.bo;

import org.example.Entity.User;
import org.example.bo.Custome.SuperBo;
import org.example.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public interface UserBo extends SuperBo {
    public boolean userSave(UserDto us);
    public List<UserDto> getAllUser(String pas, String userName);

    public UserDto getUser(int id);

    public boolean userUpdate(UserDto user);

    public boolean userDelete(int phone);

    public List<UserDto> getSearchUser(int user);

    public List<UserDto> getAllUserAll();

}
