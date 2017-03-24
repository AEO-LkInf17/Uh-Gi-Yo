package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int SERVER_PORT = 42042;

    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            while(true) {
                Socket client = server.accept();
                //TODO: handle client connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}