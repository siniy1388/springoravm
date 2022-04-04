/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.OvmmComndDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.eclipse.persistence.expressions.ExpressionOperator.Log;
import org.springframework.stereotype.Component;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    
    public StringBuilder fromStrDtoVmToOvmmComnd(StringBuilder ovmmComnd) {
//        Pattern pattern_id = Pattern.compile("id:\\d");
//        Pattern pattern_nm = Pattern.compile("name:\\d");
//        //String line = ovmmComnd;
//        Matcher matcher_id = pattern_id.matcher(ovmmComnd);
//        Matcher matcher_nm = pattern_nm.matcher(ovmmComnd);
//        String[] array = new String[3];
//        for (int i = 0; matcher_id.find(); i++) {
//            array[i] = matcher_id.group();
//        }
//        try{
//            JSONObject ovmmComndJsObj = new JSONObject(ovmmComnd);
//            JSONArray weatherArray = new JSONArray(ovmmComnd.toString());
//        }catch (JSONException err){
//            Logger.getLogger(DefaultUsersService.class.getName()).log(Level.SEVERE, null, err);
//        }
//        int iid = ovmmComnd.indexOf("id:");
//        int inm = ovmmComnd.indexOf("name:");
//        int len = ovmmComnd.length();           
//        return OvmmComndDto.builder()
//                .id(ovmmComnd.substring(iid +3, inm - 2))
//                .name(ovmmComnd.substring(inm +3, len))
////                .userid(uservm.getNameVm())
////                .command(uservm.getCdvmSystem())
//                .build();
         return ovmmComnd;
    }
    
}
