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
    
    public UserVm fromUserDtoVmToUserVm(UserVmDto userVmDto) {
        UserVm uservm = new UserVm();
        uservm.setId(userVmDto.getId());
        uservm.setName(userVmDto.getName());
        uservm.setNameVm(userVmDto.getNamevm());
        uservm.setCdvmSystem(userVmDto.getCdvmSystem());
        uservm.setUserid(userVmDto.getUserid());
        uservm.setCdvm(userVmDto.getCdvm());
        return uservm;
    }
    
    public UserVmDto fromUserVmToUserDtoVm(UserVm uservm) {
        return UserVmDto.builder()
                .id(uservm.getId())
                .name(uservm.getName())
                .namevm(uservm.getNameVm())
                .cdvmSystem(uservm.getCdvmSystem())
                .userid(uservm.getUserid())
                .cdvm(uservm.getCdvm())
                .build();
    }
    
}
