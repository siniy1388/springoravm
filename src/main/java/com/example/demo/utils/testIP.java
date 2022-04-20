/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author siniy_P
 */


public class testIP{

private final Pattern pattern;
private Matcher matcher;

private static final String IP_PATTERN = 
    "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

public testIP(){
pattern = Pattern.compile(IP_PATTERN);
}

/**
* Validate ip address with regular expression
* @param ip ip address for validation
* @return true valid ip address, false invalid ip address
*/
public boolean validate(final String ip){
matcher = pattern.matcher(ip);
return matcher.matches();
}
}
