package server.communication.packet.packets.outgoing;

import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.user.User;
//TODO Implement!
public class GetUserDataResult extends OutgoingPacket {
    public static final String COMMAND = "GETUSERDATARESULT";

    public GetUserDataResult(User targetUser) {
        super(targetUser);
    }

    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);
        JsonObject data = new JsonObject();
        packetObject.add("data", Main.GSON.toJsonTree(data));

        return packetObject;
    }
}
