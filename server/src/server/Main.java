package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;
import server.communication.packet.packets.incoming.LoginPacket;
import server.communication.packet.packets.incoming.RegisterPacket;
import server.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int SERVER_PORT = 42042;
    public static final String VERSION = "0.0-dev";
    public static final Gson GSON = new Gson();

    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started running on port " + SERVER_PORT);
            while(true) {
                Socket client = server.accept();
                new Thread(()->{
                    User user = new User(client);
                    //recieving
                    try {
                        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        while(true) {
                            JsonObject packetJson = GSON.fromJson(inFromClient.readLine(), JsonObject.class);
                            if(packetJson==null) {
                                user.disconnect();
                                break;
                            }
                            String command = packetJson.get("command").getAsString();
                            IncomingPacket packet = null;
                            switch(command) {
                                case "LOGIN":
                                    packet = new LoginPacket(user, packetJson.getAsJsonObject("data"));
                                    break;
                                case "REGISTER":
                                    packet = new RegisterPacket(user, packetJson.getAsJsonObject("data"));
                                    break;
                                default:
                                    System.out.println("unknown command incomingpacket command: " + command);
                                    break;
                            }
                            if(packet==null)
                                continue;
                            packet.handlePacket();
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