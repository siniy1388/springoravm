/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

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
//        System.out.println(tmpline);
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
//        System.out.println(tmpline);
        JSONObject ovmmComndJsObj = new JSONObject(tmpline);
        return ovmmComndJsObj;        
    }
    
}
