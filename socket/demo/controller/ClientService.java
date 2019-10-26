package socket.demo.controller;

import java.io.*;
import java.net.*;
import java.util.regex.Pattern;
/**
 *
 * @author VyVu
 */
public class ClientService extends Thread{
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public ClientService(Socket socket, DataInputStream input, DataOutputStream output) {
        this.socket = socket;
        this.input = input;
        this.output = output;
    }
    
    @Override
    public void run(){
        String talk="";
        while(!"/q".equalsIgnoreCase(talk)){
            try {
                talk=this.input.readUTF();
                if(talk.equalsIgnoreCase("/q")) System.out.print(this.socket.getRemoteSocketAddress().toString()+" disconnected!");
                else{
                    System.out.println(this.socket.getRemoteSocketAddress().toString()+" sent: "+talk);
                    if(Pattern.compile("/up .+").matcher(talk).find()){
                        this.output.writeUTF(talk.substring(4).toUpperCase());
                        this.output.flush();
                    }
                    else{
                        this.output.writeUTF("Unknown command! Use /up [String] to get uppercase string.");
                        this.output.flush();
                    }
                }
                        
            }
            catch (IOException ex) {
                try {
                    this.input.close();
                    this.output.close();
                    this.socket.close();
                }
                catch (IOException ex1) {
                    System.exit(0);
                }
            }
        }
    }
}
