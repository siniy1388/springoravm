package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolesDto implements Serializable {
    private final Long id;
    private final String roleNm;
    private final String roleRus;
    
}
