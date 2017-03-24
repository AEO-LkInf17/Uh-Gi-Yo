package server.communication.packet;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class OutgoingPacket extends Packet {
    private static List<Class<? extends OutgoingPacket>> packetTypes = new ArrayList<Class<? extends OutgoingPacket>>();

    public static void registerPacketType(Class<? extends OutgoingPacket> packetType) {
        if(!packetTypes.contains(packetType))
            packetTypes.add(packetType);
    }

    public abstract JsonObject generatePacketObject();

    protected void sendJSONObject(JsonObject packet) {

    }
}
