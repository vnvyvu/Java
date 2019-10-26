package socket.demo.model;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author VyVu
 */
public class Client {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Client(String address,int port) {
        try {
            this.socket=new Socket(address, port);
            System.out.println("Server connected!");
            
            this.input=new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
            this.output=new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
            
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            String talk="";
            while(true){
                System.out.print(this.socket.getLocalSocketAddress()+": ");
                talk=in.readLine();
                this.output.writeUTF(talk);
                this.output.flush();
                if("/q".equalsIgnoreCase(talk)) this.socket.close();
                talk=this.input.readUTF();
                System.out.println(talk);
            }
        }
        catch (IOException ex) {
            try {
                this.input.close();
                this.output.close();
                this.socket.close();
            } catch (IOException ex1) {
                System.exit(0);
            }
        }
    }
    
}
