package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;

/**
 * Created by jk0521 on 07.03.2017.
 */
public class LoginPacket extends IncomingPacket {
    private String username;
    private String version;

    public static final String COMMAND = "LOGIN";

    static {
        IncomingPacket.registerPacketType(LoginPacket.class);
    }

    public LoginPacket(JsonObject data) {
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("verison").getAsString();
    }

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void handlePacket() {

    }
}
