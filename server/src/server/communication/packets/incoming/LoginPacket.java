package server.communication.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.IncomingPacket;

public class LoginPacket extends IncomingPacket {
    private String username;
    private String version;

    public LoginPacket(JsonObject data) {
        super();
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("verison").getAsString();
    }

    @Override
    public void handlePacket() {

    }
}
