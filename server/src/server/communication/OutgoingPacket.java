package server.communication;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public abstract class OutgoingPacket extends Packet {
    private static List<Class<?>> packetTypes = new ArrayList<>();

    private static void registerPacketType(Class<?> packetType) {
        if(!packetTypes.contains(packetType))
            packetTypes.add(packetType);
    }

    public abstract JsonObject generatePacketObject();

    protected OutgoingPacket() {
        registerPacketType(this.getClass());
    }

    protected void sendJSONObject(JsonObject packet) {

    }
}