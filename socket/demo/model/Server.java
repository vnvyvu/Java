package socket.demo.model;

import java.io.*;
import java.net.*;
import socket.demo.controller.ClientService;

/**
 *
 * @author VyVu
 */
public class Server {
    private Socket socket;
    private ServerSocket server;
    private DataInputStream input;
    private DataOutputStream output;

    public Server(int port) {
        try {
            this.server=new ServerSocket(port);
            System.out.println("Server running!\nWaiting for clients...");
            
            while(true){
                try{
                    this.socket=this.server.accept();
                }
                catch(NullPointerException e1){
                    System.out.println("Server is already running!");
                    System.exit(0);
                }
                System.out.println(this.socket.getRemoteSocketAddress().toString()+" connected!");

                this.input=new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
                this.output=new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));

                Thread newClient=new ClientService(socket, input, output);
                newClient.start();
            }
        }
        catch (IOException ex) {
            System.exit(0);
        }
    }
    
}
