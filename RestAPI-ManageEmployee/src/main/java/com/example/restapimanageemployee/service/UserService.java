package com.example.restapimanageemployee.service;

import com.example.restapimanageemployee.entity.User;
import com.example.restapimanageemployee.model.dto.UserDto;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> searchUser(String keyword);

}
