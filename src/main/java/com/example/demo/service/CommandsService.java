/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.CommandsDto;
import java.util.List;

/**
 *
 * @author oleg
 */
public interface CommandsService {
    
    CommandsDto saveCommands(CommandsDto comndDto);

    void deleteCommands(Integer CommandId);

    CommandsDto findByCommand(String command);

    List<CommandsDto> findAll();
    
}
