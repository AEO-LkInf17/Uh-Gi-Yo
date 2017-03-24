package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int SERVER_PORT = 42042;

    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            while(true) {
                Socket client = server.accept();
                new Thread(()->{
                    //recieving
                    try {
                        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        while(true) {
                            String message = inFromClient.readLine();
                            //TODO: convert message to jsonobject, lookup command and instanciate the message, handle the packet
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}