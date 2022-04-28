/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oleg
 */
public interface UsersRepository extends JpaRepository<UserTable, Integer>{
    UserTable findByLogin(String login);
}
