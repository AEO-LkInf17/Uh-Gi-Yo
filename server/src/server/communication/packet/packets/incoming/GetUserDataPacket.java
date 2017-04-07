package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;
import server.user.User;

public class GetUserDataPacket extends IncomingPacket {
    private String username;

    public static final String COMMAND = "GETUSERDATA";

    public GetUserDataPacket(User sourceUser, JsonObject data) {
        super(sourceUser);
        //parse packet data
        this.username = data.get("username").getAsString();
    }

    @Override
    public void handlePacket() {

    }
}
