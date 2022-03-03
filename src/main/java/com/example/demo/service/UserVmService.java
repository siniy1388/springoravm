/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dto.UserVmDto;
import java.util.List;

/**
 *
 * @author oleg
 */
public interface UserVmService {
    
    //UserVmDto saveUser(UserVmDto userVmDto);

    UserVmDto findByUser(String name);
    
    UserVmDto findByVmName(String name);

    List<UserVmDto> findAllVm();
    
}
