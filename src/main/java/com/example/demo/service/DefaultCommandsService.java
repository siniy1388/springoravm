/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.CommandsDto;
import com.example.demo.entity.Commands;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.CommandsRepository;
import java.util.List;
import static java.util.Objects.isNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author oleg
 */
@AllArgsConstructor
@Service
public class DefaultCommandsService implements CommandsService {
    private final CommandsRepository commandsRepository;
    private final CommandsConverter commandsConverter;

    @Override
    public CommandsDto saveCommands(CommandsDto comndDto) {
        try {
            validateCommandDto(comndDto);
        } catch (ValidationException ex) {
            Logger.getLogger(DefaultCommandsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Commands savedCommand = commandsRepository.save(commandsConverter.fromComndDtoToComnd(comndDto));
        return commandsConverter.fromComndToComndDto(savedCommand);        
    }
    
    private void validateCommandDto(CommandsDto commandDto) throws ValidationException {
        if (isNull(commandDto)) {
            throw new ValidationException("Object command is null");
        }
        if (isNull(commandDto.getCommand()) || commandDto.getCommand().isEmpty()) {
            throw new ValidationException("Command is empty");
        }
    }

    @Override
    public void deleteCommands(Integer CommandId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CommandsDto findByCommand(String command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CommandsDto> findAll() {
        return commandsRepository.findAll()
                .stream()
                .map(commandsConverter::fromComndToComndDto)
                .collect(Collectors.toList());   }
    
}
