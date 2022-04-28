/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.RoleForUserDto;
import com.example.demo.service.RoleForUserService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oleg
 */
@RestController
@RequestMapping("/userRole")
@AllArgsConstructor
@Log
public class RoleForUserController {
    
    private final RoleForUserService roleforuser;
    
    
     @GetMapping("/findAll")
    public List<RoleForUserDto> findAll() {
        log.info("Handling find all roles users request");
        return roleforuser.findAll();
    }
}
