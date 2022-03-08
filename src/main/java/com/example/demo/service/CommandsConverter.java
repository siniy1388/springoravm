/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.CommandsDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.entity.Commands;
import org.springframework.stereotype.Component;

/**
 *
 * @author oleg
 */
@Component
public class CommandsConverter {
   public Commands fromComndDtoToComnd(CommandsDto comndDto) {
        Commands comnd = new Commands();
        comnd.setId(comndDto.getId());
        comnd.setGroop(comndDto.getGroop());
        comnd.setCommand(comndDto.getCommand());
        comnd.setNameR(comndDto.getNamer());
        return comnd;

    }
    
    public CommandsDto fromComndToComndDto(Commands comnd) {
        return CommandsDto.builder()
                .id(comnd.getId())
                .groop(comnd.getGroop())
                .command(comnd.getCommand())
                .namer(comnd.getNameR())
                .build();
    } 
}
