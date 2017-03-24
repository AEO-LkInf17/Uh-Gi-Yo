package server.communication.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.IncomingPacket;

public class RegisterPacket extends IncomingPacket {
    private String username;
    private String version;

    public RegisterPacket(JsonObject data) {
        super();
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("verison").getAsString();
    }

    @Override
    public void handlePacket() {

    }
}
