/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 *
 * @author oleg
 */
@Component
public class sshConvertUtils implements sshUtils {
    
    @Override
    public JSONObject strToJson(String bufline){
        int iid = bufline.indexOf("id");
        int inm = bufline.indexOf("name");
        int len = bufline.length();   
        String tmpline = "{" + "id:"+ bufline.substring(iid +3, inm - 2)
                    .replace(":", "-")+
            ",name:" + bufline.substring(inm + 5, len).replace(":", "-")+"}";
        JSONObject ovmmComndJsObj = new JSONObject(tmpline);
        return ovmmComndJsObj;        
    }
    
    @Override
    public JSONObject strVmToJson(String bufline){
        int iid = bufline.indexOf("=");
        int inm = bufline.indexOf("[");
        int len = bufline.length();   
        String tmpline = "{" + "id:"+ bufline.substring(iid +2, inm - 2) +
            ",name:" + bufline.substring(inm + 1, len-1)+"}";
        JSONObject ovmmComndJsObj = new JSONObject(tmpline);
        return ovmmComndJsObj;        
    }
    
    @Override
    public JSONObject infoToJson(String bufline){
        JSONObject res = null;
        try{
            String tmpline = "{\"" + bufline.substring(0 , bufline.indexOf("=")).trim() + "\":\""+
                        bufline.substring(bufline.indexOf("=")+1 , bufline.length()).trim() + "\"}";
            res = new JSONObject(tmpline);
        }catch(JSONException ex){
        }
        
        return res;
    }
    
    
}
