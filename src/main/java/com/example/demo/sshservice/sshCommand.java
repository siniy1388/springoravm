/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.sshservice;

// import ch.ethz.ssh2.Session;

import com.example.demo.service.DefaultUsersService;
import com.jcraft.jsch.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Level;




/**
 *
 * @author oleg
 */
public class sshCommand {
    
    String host = "192.168.0.11";
    String user = "admin";
    String passwd = "Bratsk1388";
    int port = 10000;
    private Session session;
    String charset = "UTF-8";
    
    private void Connection() throws JSchException {
       JSch js = new JSch();
       session = js.getSession(user,host,port);
       session.setPassword(passwd);
       session.setConfig("StrictHostKeyChecking", "no");
       session.connect();

   }
    
    public sshCommand(String user,String passwd,String host,int port){
       this.user = user;
       this.passwd = passwd;
       this.host = host;
       this.port = port;
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

    public void executeCmd(String command) throws JSchException, IOException {
       BufferedReader reader = null;
       Channel channel = null;
       channel = session.openChannel("exec");
       ((ChannelExec) channel).setCommand(command);
       channel.setInputStream(null);
       ((ChannelExec) channel).setErrStream(System.err);
       channel.connect();
       InputStream in = channel.getInputStream();
       
       reader = new BufferedReader(new InputStreamReader(in,
               Charset.forName(charset)));
       String buf = null;
       System.out.println("OutPutResult:"+"\n");
       StringBuffer buffer = new StringBuffer();
       while ((buf = reader.readLine()) != null) {
           System.out.println(buf);
           buffer.append(buf);
           buffer.append("\n");
       }
       System.out.println("**********************************");
               // Результат теста может быть возвращен для регулярного сопоставления для логической оценки
       System.out.println("ReturnResult:"+"\n"+buffer.toString());
       channel.disconnect();
   }

		

    
}
