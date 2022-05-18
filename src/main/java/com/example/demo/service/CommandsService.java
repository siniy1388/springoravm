
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
