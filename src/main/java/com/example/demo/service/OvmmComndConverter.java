/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.OvmmComndDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author siniy_P
 */
@Component
public class OvmmComndConverter {
    
    
    public StringBuffer fromOvmmComndDtoVmToStr(OvmmComndDto ovmmComndDto) {
        StringBuffer ovmmcomnd = new StringBuffer();
        ovmmcomnd.append(ovmmComndDto.getId());
        ovmmcomnd.append(ovmmComndDto.getName());
//        ovmmcomnd.append(ovmmComndDto.getUserid());
//        ovmmcomnd.append(ovmmComndDto.getCommand());

        return ovmmcomnd;
    }
    
    public OvmmComndDto fromStrDtoVmToOvmmComnd(StringBuffer ovmmComnd) {
//        Pattern pattern = Pattern.compile("HaT52\\d");
//    String line = "HaT523HaT524HaT525";
//    Matcher matcher = pattern.matcher(line);
//    String[] array = new String[3];
//    for (int i = 0; matcher.find(); i++) {
//        array[i] = matcher.group();
//    }
        int iid = ovmmComnd.indexOf("id:");
        int inm = ovmmComnd.indexOf("name:");
        int len = ovmmComnd.length();           
        return OvmmComndDto.builder()
                .id(ovmmComnd.substring(iid +3, inm - 2))
                .name(ovmmComnd.substring(inm +3, len))
//                .userid(uservm.getNameVm())
//                .command(uservm.getCdvmSystem())
                .build();
    }
    
}
