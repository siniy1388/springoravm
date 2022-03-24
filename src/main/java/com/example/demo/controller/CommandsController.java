/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.CommandsDto;
import com.example.demo.service.CommandsService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oleg
 */
@RestController
@RequestMapping("/commands")
@AllArgsConstructor
@Log
public class CommandsController {
    private final CommandsService commandService;
    
     @GetMapping("/findAll")
    public List<CommandsDto> findAllCommands() {
        log.info("Handling find all users request");
        return commandService.findAll();
    }
}
