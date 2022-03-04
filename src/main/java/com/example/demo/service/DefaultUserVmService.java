/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.UserVmDto;
import com.example.demo.entity.UserVm;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserVmRepository;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author oleg
 */
@AllArgsConstructor
@Service
public class DefaultUserVmService implements UserVmService {
    
    private final UserVmRepository userVmRepository;
    private final UserVmConverter userVmConverter;

//    @Override
//    public UserVmDto saveUser(UserVmDto userVmDto) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public UserVmDto findByUser(String name) {
        UserVm users = userVmRepository.findByName(name);
        if (users != null) {
            return userVmConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public UserVmDto findByVmName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserVmDto> findAll() {
        return userVmRepository.findAll()
                .stream()
                .map(userVmConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
    
    private void validateUserDto(UserVmDto userVmDto) throws ValidationException {
        if (isNull(userVmDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userVmDto.getName()) || userVmDto.getName().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    
}
