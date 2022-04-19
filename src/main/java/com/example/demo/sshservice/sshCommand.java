/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.sshservice;

// import ch.ethz.ssh2.Session;

import com.example.demo.dto.OvmmComndDto;
import com.example.demo.service.DefaultUsersService;
import com.jcraft.jsch.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Level;
import org.apache.tomcat.util.json.ParseException;
import utils.sshConvertUtils;




/**
 *
 * @author oleg
 */
public class sshCommand {
    
    private sshConvertUtils sshutils;
    
    String host = "192.168.0.11";
    String user = "admin";
    String passwd = "Bratsk1388";
    int port = 10000;
    private Session session;
    String charset = "UTF-8";
    BufferedReader reader = null;
    Channel channel = null;
       
    
    private void Connection() throws JSchException {
       JSch js = new JSch();
       session = js.getSession(user,host,port);
       session.setPassword(passwd);
       session.setConfig("StrictHostKeyChecking", "no");
       session.connect();
       channel = session.openChannel("exec");
       sshutils = new sshConvertUtils();
   }
    
    public sshCommand(){
       try{
           Connection() ;
       } catch(JSchException ex)  {
           java.util.logging.Logger.getLogger(DefaultUsersService.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

    
   public void disconnection(){
       if (session !=null && session.isConnected()){
           session.disconnect();
       }
   }

    public StringBuilder executeCmd(String command) throws JSchException, IOException {
//       BufferedReader reader = null;
//       Channel channel = null;
//       channel = session.openChannel("exec");
       ((ChannelExec) channel).setCommand(command);
       channel.setInputStream(null);
       ((ChannelExec) channel).setErrStream(System.err);
       channel.connect();
       InputStream in = channel.getInputStream();
       
       reader = new BufferedReader(new InputStreamReader(in,
               Charset.forName(charset)));
       String buf;
       System.out.println("OutPutResult:"+"\n");
       StringBuilder buffer = new StringBuilder();
       //String ttt;
       buffer.append("[");
       while ((buf = reader.readLine()) != null) {
           //System.out.println(buf);
           if (!buf.contains("Command") && !buf.contains("Status") 
               && !buf.contains("Time") && !buf.contains("Data") 
               && !buf.contains("OVM") && !buf.isEmpty()){
                    buffer.append(sshutils.strToJson(buf));
                    buffer.append(",");
                 //   buffer.append("\n");
           }
       }
       StringBuilder buff1 = new StringBuilder(buffer.toString()
                   .substring(0,buffer.length()-1));
       buff1.append("]");
       channel.disconnect();
        return buff1;
   }
    
    public StringBuilder getServerInfo(String servID) throws JSchException, IOException, ParseException {
//        System.out.println("!!!-----------getServerInfo--------------!!!");
//       BufferedReader reader = null;
//       Channel channel = null;
//       channel = session.openChannel("exec");
       String command = "show Server id=" + servID.replaceAll("-", ":");
       ((ChannelExec) channel).setCommand(command);
       channel.setInputStream(null);
       ((ChannelExec) channel).setErrStream(System.err);
       channel.connect();
       InputStream in = channel.getInputStream();
       reader = new BufferedReader(new InputStreamReader(in,
               Charset.forName(charset)));
       String buf;
       StringBuilder buffer = new StringBuilder();
       //String ttt;
       buffer.append("[");
       while ((buf = reader.readLine()) != null) {
           //System.out.println(buf);
           if (buf.contains("Vm ") && !buf.contains("Ability")){
                    buffer.append(sshutils.strVmToJson(buf));
                    buffer.append(",");
                 //   buffer.append("\n");
           }
       }
       buffer = new StringBuilder(buffer.toString()
                   .substring(0,buffer.length()-1));
       buffer.append("]");
       channel.disconnect();
        return buffer;
   }
    
    public StringBuilder getVmInfo(String vmID) throws JSchException, IOException, ParseException {
//        System.out.println("!!!-----------getServerInfo--------------!!!");
//       BufferedReader reader = null;
//       Channel channel = null;
//       channel = session.openChannel("exec");
       String command = "show vm id=" + vmID;
       ((ChannelExec) channel).setCommand(command);
       channel.setInputStream(null);
       ((ChannelExec) channel).setErrStream(System.err);
       channel.connect();
       InputStream in = channel.getInputStream();
       reader = new BufferedReader(new InputStreamReader(in,
               Charset.forName(charset)));
       String buf;
       StringBuilder buffer = new StringBuilder();
       //String ttt;
      // buffer.append("[");
       while ((buf = reader.readLine()) != null) {
           //System.out.println(buf);
          // if (buf.contains("Vm ") && !buf.contains("Ability")){
                    buffer.append(buf);
                   // buffer.append(",");
                 //   buffer.append("\n");
          // }
       }
//       buffer = new StringBuilder(buffer.toString()
//                   .substring(0,buffer.length()-1));
      // buffer.append("]");
       channel.disconnect();
        return buffer;
   }
    
//    private JSONObject strToJson(String bufline){
//        int iid = bufline.indexOf("id");
//        int inm = bufline.indexOf("name");
//        int len = bufline.length();   
//        String tmpline = "{" + "id:"+ bufline.substring(iid +3, inm - 2)
//                    .replace(":", "-")+
//            ",name:" + bufline.substring(inm + 5, len).replace(":", "-")+"}";
//        System.out.println(tmpline);
//        JSONObject ovmmComndJsObj = new JSONObject(tmpline);
//        return ovmmComndJsObj;        
//    }
    
//    private JSONObject strVmToJson(String bufline){
//        int iid = bufline.indexOf("=");
//        int inm = bufline.indexOf("[");
//        int len = bufline.length();   
//        String tmpline = "{" + "id:"+ bufline.substring(iid +2, inm - 2) +
//            ",name:" + bufline.substring(inm + 1, len-1)+"}";
//        System.out.println(tmpline);
//        JSONObject ovmmComndJsObj = new JSONObject(tmpline);
//        return ovmmComndJsObj;        
//    }
    
}
