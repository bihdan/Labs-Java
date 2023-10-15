/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.server;

//import sumdu.server.ClientThread;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author bogda
 */
public class ChatServer implements Runnable {
    private Map<Integer, Socket> mapClient = new TreeMap<Integer,Socket>();
            
    @Override
    public void run(){
        ServerSocket ss = null;
        try { 
           ss = new ServerSocket(8889);
           System.out.println("Server is waiting...");
           int numberClient = 1;
           Socket client = null;
           
           while(true){
               client = ss.accept();
               Thread clientThread = new Thread(new ClientThread(client, this, numberClient));
               clientThread.setDaemon(true);
               clientThread.start();
               mapClient.put(numberClient, client);
               numberClient++;
           }
            
        } catch (IOException e) {
//                e.printStackTrace();
                throw new RuntimeException(e);
        }
        finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException ioe) {
//                ioe.printStackTrace();
                throw new RuntimeException(ioe);
            }
        }
    }
    public void delClient(int numberClient){ // видаляє клієнта з mapClient
        mapClient.remove(numberClient);
    }
    
    public void sendMessageForAllClient(int numberClient, String clientMassage){
        if(mapClient.size() > 1){
//            for(int i = 1; i <= mapClient.size(); i++) {
//                if(numberClient != i /*&& mapClient.get(i).isConnected()*/){
//                    if(/*mapClient.get(i).isClosed()*/mapClient.){
//                        mapClient.remove(i);
//                    } else{
//                        try{
//                            new PrintWriter(new OutputStreamWriter(mapClient.get(i).getOutputStream()), true).println("from client №" + numberClient +" : " + clientMassage);
//                        } catch(IOException e){
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    
//                }
//            }
            for (Map.Entry<Integer, Socket> str: mapClient.entrySet()) {
                int k =  str.getKey();
                if(numberClient != k){
//                    
//                    if(mapClient.get(k).isClosed()){
//                        mapClient.remove(k);
//                    } else{
                        try{
                            new PrintWriter(new OutputStreamWriter(mapClient.get(k).getOutputStream()), true).println("from client №" + numberClient +" : " + clientMassage);
                        } catch(IOException e){
                            throw new RuntimeException(e);
                        }
//                    }
                    
                }
            }
        
        } else{
            System.out.println("There is no client to send the message to");
        }
        
        
        
        /*String messageForClients = null;
        PrintWriter out = null;
        OutputStreamWriter osw = null;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                System.out.println("\nEnter message for clients: ");
                messageForClients = inputUser.readLine();
                
                for(int i = 1; i <= mapClient.size(); i++) {
                    osw = new OutputStreamWriter(mapClient.get(i).getOutputStream());
                    out = new PrintWriter(osw, true);
                    out.println(messageForClients);
                    //new PrintWriter(new OutputStreamWriter(mapClient.get(i).getOutputStream()), true).println(messageForClients);
                }
           } catch(IOException e){
                throw new RuntimeException(e);
            }
                
        }*/
        
    }
    
    
}
