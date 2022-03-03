/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

/**
 *
 * @author oleg
 */
import com.example.demo.dto.UserVmDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.UserVmService;

/**
 *
 * @author oleg
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UserVmController {
    
    private final UserVmService userVmService;

//    @PostMapping("/saveUVm")
//    public UserVmDto saveUsers(@RequestBody UserVmDto userVmDto) throws ValidationException {
//        System.out.println("User + VM !!!!!");
//        log.info("Handling save users: " + userVmDto);
//        return userVmService.saveUser(userVmDto);
//    }

    @GetMapping("/findAllVm")
    public List<UserVmDto> findAllUsers() {
        log.info("Handling find all usersvm request");
        return userVmService.findAllVm();
    }

    @GetMapping("/findByUser")
    public UserVmDto findByUser(@RequestParam String name) {
        log.info("Handling find by user request: " + name);
        return userVmService.findByUser(name);
    }
    
    @GetMapping("/findByVmName")
    public UserVmDto findByVmName(@RequestParam String name) {
        log.info("Handling find by vm name request: " + name);
        return userVmService.findByVmName(name);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
//        log.info("Handling delete user request: " + id);
//        userVmService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }
    
}
