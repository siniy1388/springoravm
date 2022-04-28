/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import org.springframework.stereotype.Component;
import com.example.demo.dto.RoleForUserDto;
import com.example.demo.entity.Vroleforusers;

/**
 *
 * @author oleg
 */
@Component
public class RoleForUserConverter {
        
     public RoleForUserDto fromRoleForUserToRoleForUserDto(Vroleforusers roleforuser) {
        return RoleForUserDto.builder()
                .id(roleforuser.getId())
                .userid(roleforuser.getUserid())
                .login(roleforuser.getLogin())
                .roleid(roleforuser.getRoleid())
                .rolenm(roleforuser.getRoleNm() )
                .build();
    }
}
