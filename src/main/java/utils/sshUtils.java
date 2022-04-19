/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

import org.json.JSONObject;

/**
 *
 * @author oleg
 */
public interface sshUtils {
    
    public JSONObject strVmToJson(String bufline);
    
    public JSONObject strToJson(String bufline);
    
    public JSONObject infoToJson(String bufline);

}
