/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.client;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author bogda
 */
public class ConnectInputMessage implements Runnable{
    private Socket serverConnect;
    private InputStream inputStreamServer;
    
    public ConnectInputMessage(){
        try {
            serverConnect = new Socket("localhost", 8889);
            inputStreamServer = serverConnect.getInputStream();
        } catch(IOException e){
            throw new RuntimeException(e);
            
        }
    }
    
    @Override
    public void run(){
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMassage;
        
        while(true){
           try{
               serverMassage = in.readLine();
               if(serverMassage != null){
                   System.out.println(serverMassage + '\n');
                   break;
               }
           } catch(IOException e){
            throw new RuntimeException(e);
            }
                
        }
        
        PrintWriter out = null;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
        
        String userMessage = null;
        
        while(true){
            System.out.println("Enter message: ");
           try{
               userMessage = inputUser.readLine();
               out = new PrintWriter(serverConnect.getOutputStream(),true);
               out.println(userMessage);
           } catch(IOException e){
                throw new RuntimeException(e);
            }
                
        }
    }
    
    public InputStream getInputStreamServer(){
        return inputStreamServer;
    }
}
