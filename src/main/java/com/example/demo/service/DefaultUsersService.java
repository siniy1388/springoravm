/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dto.UsersDto;
import com.example.demo.entity.UserTable;
import com.example.demo.exception.ValidationException;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UsersRepository;
import com.example.demo.sshservice.sshCommand;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author oleg
 */
@AllArgsConstructor
@Service
public class DefaultUsersService implements UsersService {
    
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        
        try {
            validateUserDto(usersDto);
        } catch (ValidationException ex) {
            Logger.getLogger(DefaultUsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserTable savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        UserTable users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
    

}


