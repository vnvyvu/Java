package socket.demo.view;

import java.io.IOException;
import socket.demo.model.Client;

/**
 *
 * @author VyVu
 */
public class ClientView {
    public static void main(String[] args) throws IOException {
        Client client=new Client("127.0.0.1", 21312);
    }
}
