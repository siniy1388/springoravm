/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dto.UserVmDto;
import com.example.demo.entity.UserVm;
import org.springframework.stereotype.Component;

/**
 *
 * @author oleg
 */
@Component
public class UserVmConverter {
    
    public UserVm fromUserDtoToUser(UserVmDto userVmDto) {
        UserVm uservm = new UserVm();
        uservm.setId(userVmDto.getId());
        uservm.setCdvm(userVmDto.getCdvm());
        uservm.setNameVm(userVmDto.getNamevm());
        uservm.setName(userVmDto.getName());
        uservm.setUserid(userVmDto.getUserid());
        return uservm;
    }
    
    public UserVmDto fromUserToUserDto(UserVm uservm) {
        return UserVmDto.builder()
                .id(uservm.getId())
                .cdvm(uservm.getCdvm())
                .cdvmSystem(uservm.getCdvmSystem())
                .name(uservm.getName())
                .namevm(uservm.getNameVm())
                .build();
    }
    
}
