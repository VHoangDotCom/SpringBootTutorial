package com.example.restapimanageemployee.service;

import com.example.restapimanageemployee.entity.User;
import com.example.restapimanageemployee.exception.NotFoundException;
import com.example.restapimanageemployee.model.dto.UserDto;
import com.example.restapimanageemployee.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1,"John Doe","doe@gmail.com","03423423","avatar.img","hello123@"));
        users.add(new User(2,"John Deep","deep@gmail.com","04332432","avatar1.img","hirherew@"));
        users.add(new User(3,"John Kaisa","kaisa@gmail.com","0324234325","avatar2.img","hithere123@"));
    }

    @Override
    public List<UserDto> getListUser(){
        List<UserDto> result = new ArrayList<UserDto>();
        for(User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id){
        for(User user : users){
            if(user.getId() == id){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("No user found !");
    }

    @Override
    public List<UserDto> searchUser(String keyword){
        List<UserDto> result = new ArrayList<>();
        for(User user : users){
            if (user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }


}
