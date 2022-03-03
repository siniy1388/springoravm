/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dto.UsersDto;
import com.example.demo.entity.UserTable;
import org.springframework.stereotype.Component;

/**
 *
 * @author oleg
 */
@Component
public class UsersConverter {
    
    public UserTable fromUserDtoToUser(UsersDto usersDto) {
        UserTable users = new UserTable();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        return users;

    }
    
    public UsersDto fromUserToUserDto(UserTable users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
    
}
