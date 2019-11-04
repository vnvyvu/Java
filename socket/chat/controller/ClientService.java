package socket.chat.controller;

import java.io.*;
import java.net.*;
/**
 *
 * @author VyVu
 */
public class ClientService implements Runnable{
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private String inputMessage,outputMessage;

    public ClientService(Socket socket, DataInputStream input, DataOutputStream output) {
        this.socket = socket;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        String clientAddress=this.socket.getRemoteSocketAddress().toString();
        while(true){
            try {
                this.inputMessage=this.input.readUTF();
                if(!"/q".equalsIgnoreCase(this.inputMessage)) System.out.println(clientAddress+": "+this.inputMessage);
                else{
                    System.out.println(clientAddress+" disconnected!");
                    this.socket.close();
                }
            } catch (IOException ex) {
                System.out.println(clientAddress+" disconnected!");
                System.exit(0);
            }
        }
    }
    
}
