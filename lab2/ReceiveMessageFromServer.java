/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author bogda
 */
public class ReceiveMessageFromServer implements Runnable{
    private InputStream inputStreamServer;
    
    public ReceiveMessageFromServer(InputStream inputStream){
        this.inputStreamServer = inputStream;
    }
    
    @Override
    public void run(){
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        
        while(true){
           try{
               serverMessage = in.readLine();
               if(serverMessage != null){
                   System.out.println(serverMessage + "\nEnter message");
               }
           } catch(IOException e){
            throw new RuntimeException(e);
            }
                
        }
    }
    
}
