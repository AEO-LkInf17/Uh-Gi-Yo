package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;

/**
 * Created by jk0521 on 07.03.2017.
 */
public class RegisterPacket extends IncomingPacket {
    private String username;
    private String version;

    static {
        IncomingPacket.registerPacketType(RegisterPacket.class);
    }

    public RegisterPacket(JsonObject data) {
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("verison").getAsString();
    }

    @Override
    public void handlePacket() {

    }
}
