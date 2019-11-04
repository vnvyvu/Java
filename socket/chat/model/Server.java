package socket.chat.model;

import java.io.*;
import java.net.*;

/**
 *
 * @author VyVu
 */
public class Server{
    private Socket socket;
    private ServerSocket server;
    private DataInputStream input;
    private DataOutputStream output;

    public Server(int port) {
        try {
            this.server=new ServerSocket(port);
            System.out.println("Server opened!\nWaiting for clients...");
            this.socket=this.server.accept();
            System.out.println(this.socket.getRemoteSocketAddress().toString().substring(1)+" connected!");
            
            this.input=new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
            this.output=new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
            
            
            
        }
        catch (IOException ex) {
            
        }
        
    }
    
}
