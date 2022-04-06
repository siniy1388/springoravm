/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.OvmmComndDto;
import com.example.demo.sshservice.sshCommand;
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

/**
 *
 * @author siniy_P
 */
@AllArgsConstructor
@Service
public class DefaultOvmmComndService implements OvmmComndService {
    
       private final OvmmComndConverter ovmmcomndconverter;
    
    @Override
    public StringBuilder execComnd(String command) {
        // String command = "list vm";
        StringBuilder ressh = null;
        try{
            sshCommand cmnd = new sshCommand(); // "admin","Bratsk1388","192.168.0.11",10000
            ressh =  ovmmcomndconverter.fromStrDtoVmToOvmmComnd(cmnd.executeCmd(command));
//            return (OvmmComndDto) ovmmcomndconverter.fromStrDtoVmToOvmmComnd(ressh);
        } catch(JSchException | IOException ex) {
            Logger.getLogger(DefaultUsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ressh;
    }
    
    @Override
    public StringBuilder getServerInfo(String serverID){
        StringBuilder ressh = null;
        try{
            sshCommand cmnd = new sshCommand(); // "admin","Bratsk1388","192.168.0.11",10000
            ressh =  ovmmcomndconverter.fromStrDtoVmToOvmmComnd(cmnd.getServerInfo(serverID));
//            return (OvmmComndDto) ovmmcomndconverter.fromStrDtoVmToOvmmComnd(ressh);
        } catch(JSchException | IOException ex) {
            Logger.getLogger(DefaultUsersService.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (ParseException ex) {
               Logger.getLogger(DefaultOvmmComndService.class.getName()).log(Level.SEVERE, null, ex);
           }
        return ressh;
    }
    
}
