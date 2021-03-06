/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;
import com.example.demo.dto.UserVmDto;
import com.example.demo.entity.UserVm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oleg
 */
public interface UserVmRepository extends JpaRepository<UserVm, Integer>{
    UserVm findByName(String user);
    
    @Override
    List<UserVm> findAll();
    
}
