/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dto;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author oleg
 */
@Data
@Builder
public class UsersDto {
    private Integer id;
    private String name;
    private String login;
    private String email;
    
}
