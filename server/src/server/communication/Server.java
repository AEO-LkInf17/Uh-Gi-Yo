package server.communication;


import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.IncomingPacket;
import server.communication.packet.packets.incoming.GetUserDataPacket;
import server.communication.packet.packets.incoming.KeepAlivePacket;
import server.communication.packet.packets.incoming.LoginPacket;
import server.communication.packet.packets.incoming.RegisterPacket;
import server.communication.packet.packets.incoming.ChooseActivityPacket;
import server.logic.Activity.Activities.AttackActivity;
import server.logic.cards.MonsterCard;
import server.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int SERVER_PORT = 42042;

    public Server() {
        //cut
        new Thread(()->{
            try {
                ServerSocket server = new ServerSocket(SERVER_PORT);
                System.out.println("Server started running on port " + SERVER_PORT);
                while(true) {
                    Socket client = server.accept();
                    new Thread(()->{
                        User user = new User(client);
                        //TESTORT für sebastian
                        user.sendActivityList(20, new AttackActivity(new MonsterCard("a", "t", 1, 2, 3, 4, 5), new MonsterCard("a", "t", 1, 2, 3, 4, 5)));

                        //bis hier
                        //recieving
                        try {
                            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            while(true) {
                                JsonObject packetJson = Main.GSON.fromJson(inFromClient.readLine(), JsonObject.class);
                                if(packetJson==null) {
                                    user.disconnect();
                                    break;
                                }
                                String command = packetJson.get("command").getAsString();
                                IncomingPacket packet = null;
                                switch(command) {
                                    case LoginPacket.COMMAND:
                                        packet = new LoginPacket(user, packetJson.getAsJsonObject("data"));
                                        break;
                                    case RegisterPacket.COMMAND:
                                        packet = new RegisterPacket(user, packetJson.getAsJsonObject("data"));
                                        break;
                                    case KeepAlivePacket.COMMAND:
                                        packet = new KeepAlivePacket(user);
                                        break;
                                    case GetUserDataPacket.COMMAND:
                                        packet = new GetUserDataPacket(user, packetJson.getAsJsonObject("data"));
                                        break;
                                    case ChooseActivityPacket.COMMAND:
                                        packet = new ChooseActivityPacket(user, packetJson.getAsJsonObject("data"));
                                    default:
                                        System.out.println("unknown command incomingpacket command: " + command);
                                        break;
                                }
                                if(packet==null)
                                    continue;
                                packet.handlePacket();
                            }
                        } catch (SocketException e) {

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            while(true) {
                long timeNow = System.currentTimeMillis();
                List<User> userConnected = User.getUserConnected();
                List<User> userToDisconnect = new ArrayList<User>();
                for (User user : userConnected) { //TODO: heres a race condition, congrats, you finally must fix all this stuff and make it synchron....... imma go kms
                    if (user.getLastKeepAliveArrival() + Main.timeout*1000 < timeNow)
                        userToDisconnect.add(user);
                    new server.communication.packet.packets.outgoing.KeepAlivePacket(user).sendPacket();
                }
                for(User user : userToDisconnect) {
                    user.disconnect();
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
