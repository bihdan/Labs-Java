/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.server;

//import sumdu.server.ClientThread;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
           System.out.println("Waiting..."); 
//           Socket client = ss.accept();
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
           /*try {
             System.out.println("Connected"); 
             OutputStream out = client.getOutputStream();
             try {
               out.write(10);
             } finally { 
               out.close(); 
             } 
           } finally { 
             client.close(); 
           }*/
            
        } catch (IOException e) {
//                e.printStackTrace();
                throw new RuntimeException(e);
        } /*catch (SocketException uhe) {
            uhe.printStackTrace();
        }*/
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
    
        
        /* catch (SocketException e){
            
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        finally  { 
            ss.close(); 
        }*/

    }
    
}
