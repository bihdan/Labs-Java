/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sumdu.server;

import sumdu.server.ChatServer;

/**
 *
 * @author bogda
 */
public class Server {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread tChatServer = new Thread((Runnable) chatServer);
        tChatServer.start();
    }
}
