package com.example.restapimanageemployee.model.mapper;

import com.example.restapimanageemployee.entity.User;
import com.example.restapimanageemployee.model.dto.UserDto;

public class UserMapper {
    //Tai su dung code
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());

        return tmp;
    }


}
