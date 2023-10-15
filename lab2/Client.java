/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sumdu.client;

/**
 *
 * @author bogda
 */
public class Client {

    public static void main(String[] args) {
        ConnectInputMessage ConnectWithServer = new ConnectInputMessage();
        Thread tConnectInputMessage = new Thread(ConnectWithServer);
        tConnectInputMessage.start();
        
        ReceiveMessageFromServer receiveMessage = 
                new ReceiveMessageFromServer(ConnectWithServer.getInputStreamServer());
        Thread tReceiveMessage = new Thread(receiveMessage);
        tReceiveMessage.start();
    }
}
