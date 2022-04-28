/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.entity.Vroleforusers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oleg
 */
public interface RoleForUserRepository extends JpaRepository<Vroleforusers, Integer> {
//    Vroleforusers findByLogin(String login);
//    
//    Vroleforusers findByRoleNm(String rolenm);
//    
//    Vroleforusers findByRoleid(Integer roleid);
//    
//    Vroleforusers findByUserid(Integer userid);
    
}
