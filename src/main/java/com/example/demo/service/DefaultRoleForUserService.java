/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.RoleForUserDto;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.RoleForUserRepository;
import java.util.List;
import static java.util.Objects.isNull;
import com.example.demo.sshservice.sshCommand;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oleg
 */
@AllArgsConstructor
@Service
public class DefaultRoleForUserService {
    private final RoleForUserRepository roleforuserrep;
    private final RoleForUserConverter roleforuserconverter;
    
    @Override
    public List<RoleForUserDto> findAll() {
        return roleforuserrep.findAll()
                .stream()
                .map(roleforuserconverter::fromRoleForUserToRoleForUserDto)
                .collect(Collectors.toList());
    }
    
}
