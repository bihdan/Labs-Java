/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.server;

//import sumdu.server.ChatServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *
 * @author bogda
 */
public class ClientThread implements Runnable{
    Socket clientSocket;
    ChatServer chatServer;
    int numberClient;
    
    public ClientThread(Socket clientSocket, ChatServer chatServer, int number){
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
        this.numberClient = number;
    }
    
    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            System.out.println("Client №" + numberClient + " is connected.");
            new PrintWriter(clientSocket.getOutputStream(),true).println("Client №" + numberClient + ".");
            String clientMessage = null;
            
            while(true){
               clientMessage = in.readLine();
               if(!"exit".equals(clientMessage)){
                   System.out.println("Client №" + numberClient + ": " + clientMessage);
                   chatServer.sendMessageForAllClient(numberClient, clientMessage);
               } else{  // викликається метод видалення та повідомляє, що клієнт написав exit та закриває коннект
                   try {
                        chatServer.delClient(numberClient);
                        System.out.println("Client №" + numberClient + " EXITED.");
                        if (clientSocket != null) {
                            clientSocket.close();
                        }
                    } catch (IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                    break;
               }
           }
        } catch(IOException e){
            throw new RuntimeException(e);
            
        }
    }
}
