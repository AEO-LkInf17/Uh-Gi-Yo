package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int SERVER_PORT = 42042;

    public static void main(String args[]) {
        Gson gson = new Gson();
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            while(true) {
                Socket client = server.accept();
                new Thread(()->{
                    //recieving
                    try {
                        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        while(true) {
                            JsonObject packet = gson.fromJson(inFromClient.readLine(), JsonObject.class);
                            String command = packet.get("command").getAsString();

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