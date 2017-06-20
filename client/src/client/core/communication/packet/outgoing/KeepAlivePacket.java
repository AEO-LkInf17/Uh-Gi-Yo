package client.core.communication.packet.outgoing;

import client.core.communication.packet.OutgoingPacket;
import com.google.gson.JsonObject;

public class KeepAlivePacket extends OutgoingPacket {

    public static final String COMMAND = "KEEPAILVE";

    public KeepAlivePacket() {
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
