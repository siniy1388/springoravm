/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;

import com.example.demo.service.OvmmComndService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author siniy_P
 */
@RestController
@RequestMapping("/ovmm_commands")
@AllArgsConstructor
@Log
public class OvmmController {
    
    private final OvmmComndService ovmmcomndservice;
    
//     @GetMapping("/ExecComnd")
//    public List<OvmmComndDto> execComnd(@RequestParam String command) {
//        log.info("Handling ExecComnd:" + command);
//        return ovmmcomndservice.execComnd(command);
//    }
    
    @GetMapping("/ExecComndDto")
    public StringBuilder execComnd(@RequestParam String command) {
        return ovmmcomndservice.execComnd(command);
    }
    
    @GetMapping("/getServerInfo")
    public StringBuilder getServerInfo(@RequestParam String serverID) {
        return ovmmcomndservice.getServerInfo(serverID);
    }
    
    @GetMapping("/getVmInfo")
    public StringBuilder getVmInfo(@RequestParam String vmId) {
        return ovmmcomndservice.getVmInfo(vmId);
    }
    
    @GetMapping("/startVm")
    public StringBuilder startVm(@RequestParam String vmId) {
        return ovmmcomndservice.startVm(vmId);
    }
    
}
