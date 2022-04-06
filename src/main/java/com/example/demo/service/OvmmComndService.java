/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;


import com.example.demo.dto.OvmmComndDto;

/**
 *
 * @author siniy_P
 */
public interface OvmmComndService {
    StringBuilder execComnd(String command);
    
    StringBuilder getServerInfo(String serverID);
}
