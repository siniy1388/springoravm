/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CommandsDto {
    private Long id;
    private String groop;
    private String command;
    private String namer;
}
