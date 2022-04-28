/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.RoleForUserDto;
import java.util.List;

/**
 *
 * @author oleg
 */
public interface RoleForUserService {
    
    RoleForUserDto findByLogin(String login);
    
    RoleForUserDto findByRoleNm(String rolenm);
    
    RoleForUserDto findByRoleid(Integer roleid);
    
    RoleForUserDto findByUserid(Integer userid);
    
    List<RoleForUserDto> findAll();
    
}
