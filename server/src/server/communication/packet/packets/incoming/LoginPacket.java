package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;
import server.user.User;

public class LoginPacket extends IncomingPacket {
    private String username;
    private String version;

    public static final String COMMAND = "LOGIN";

    public LoginPacket(User sourceUser, JsonObject data) {
        super(sourceUser);
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("version").getAsString();
    }

    @Override
    public void handlePacket() {
        System.out.println("packet arrived: " + COMMAND + ":: username: " + username + ", version:" + version);
    }
}
